/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : AccessLogFilter
 * Date Created : 2022-12-20
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-12-20       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.spring_cloud_gateway.filter;

/**
 * @program: com.example.spring_cloud_gateway.filter
 * @description: xxx
 * @author: w15021
 * @create: 2022-12-20
 **/

import com.example.spring_cloud_gateway.entity.GatewayLog;
//import io.netty.util.internal.ObjectUtil;
//import io.netty.util.internal.StringUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.rewrite.CachedBodyOutputMessage;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.BodyInserterContext;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerStrategies;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.util.WebUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 日志过滤器，用于记录日志
 * @author jianzh5
 * @date 2020/3/24 17:17
 * https://springboot.io/t/topic/3496
 */
@Slf4j
@Component
public class AccessLogFilter implements GlobalFilter, Ordered {

    private final List<HttpMessageReader<?>> messageReaders = HandlerStrategies.withDefaults().messageReaders();

    @Override
    public int getOrder() {
        return -100;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("######################   order -100 filter working");

        ServerHttpRequest request = exchange.getRequest();

        // 请求路径
        String requestPath = request.getPath().pathWithinApplication().value();

        Route route = getGatewayRoute(exchange);


        String ipAddress = request.getRemoteAddress().getHostString();//WebUtils.getServerHttpRequestIpAddress(request);

        GatewayLog gatewayLog = new GatewayLog();
        gatewayLog.setSchema(request.getURI().getScheme());
        gatewayLog.setRequestMethod(request.getMethodValue());
        gatewayLog.setRequestPath(requestPath);
        gatewayLog.setTargetServer(route.getId());
        gatewayLog.setRequestTime(new Date());
        gatewayLog.setIp(ipAddress);

        MediaType mediaType = request.getHeaders().getContentType();

        if(MediaType.APPLICATION_FORM_URLENCODED.isCompatibleWith(mediaType) || MediaType.APPLICATION_JSON.isCompatibleWith(mediaType)){
            return writeBodyLog(exchange, chain, gatewayLog);
        }else{
            return writeBasicLog(exchange, chain, gatewayLog);
        }
    }

    private Mono<Void> writeBasicLog(ServerWebExchange exchange, GatewayFilterChain chain, GatewayLog accessLog) {
        StringBuilder builder = new StringBuilder();
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        //拼接成json string，方便给apilog赋值。
        builder.append("{");
        for (Map.Entry<String, List<String>> entry : queryParams.entrySet()) {
            //builder.append(entry.getKey()).append("=").append(entry.getValue()/*StringUtils.join(entry.getValue(), ",")*/);
            //builder.append(entry.getKey()).append("=").append(String.join(",", entry.getValue()));
            String key = entry.getKey();
            String value = String.join(",", entry.getValue());
            builder.append('"').append(key).append('"').append(":")
            .append('"').append(value).append('"').append(",");
        }
        //去掉最后一个逗号
        int length = builder.length();
        builder.deleteCharAt(length - 1);
        builder.append("}");
        String requestString = builder.toString();
        accessLog.setRequestBody(requestString);
        ObjectMapper objectMapper = new ObjectMapper();
        //ObjectNode objectNode = new ObjectMapper().createObjectNode();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(requestString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonNode.toPrettyString());


        //获取响应体
        ServerHttpResponseDecorator decoratedResponse = recordResponseLog(exchange, accessLog);

        return chain.filter(exchange.mutate().response(decoratedResponse).build())
                .then(Mono.fromRunnable(() -> {
                    // 打印日志
                    writeAccessLog(accessLog);
                }));
    }


    /**
     * 解决 request body 只能读取一次问题，
     * 参考: org.springframework.cloud.gateway.filter.factory.rewrite.ModifyRequestBodyGatewayFilterFactory
     * @param exchange
     * @param chain
     * @param gatewayLog
     * @return
     */
    @SuppressWarnings("unchecked")
    private Mono writeBodyLog(ServerWebExchange exchange, GatewayFilterChain chain, GatewayLog gatewayLog) {
        ServerRequest serverRequest = ServerRequest.create(exchange,messageReaders);

        Mono<String> modifiedBody = serverRequest.bodyToMono(String.class)
                .flatMap(body ->{
                    gatewayLog.setRequestBody(body);
                    return Mono.just(body);
                });

        // 通过 BodyInserter 插入 body(支持修改body), 避免 request body 只能获取一次
        BodyInserter bodyInserter = BodyInserters.fromPublisher(modifiedBody, String.class);
        HttpHeaders headers = new HttpHeaders();
        headers.putAll(exchange.getRequest().getHeaders());
        // the new content type will be computed by bodyInserter
        // and then set in the request decorator
        headers.remove(HttpHeaders.CONTENT_LENGTH);

        CachedBodyOutputMessage outputMessage = new CachedBodyOutputMessage(exchange, headers);

        return bodyInserter.insert(outputMessage,new BodyInserterContext())
                .then(Mono.defer(() -> {
                    // 重新封装请求
                    ServerHttpRequest decoratedRequest = requestDecorate(exchange, headers, outputMessage);

                    // 记录响应日志
                    ServerHttpResponseDecorator decoratedResponse = recordResponseLog(exchange, gatewayLog);

                    // 记录普通的
                    return chain.filter(exchange.mutate().request(decoratedRequest).response(decoratedResponse).build())
                            .then(Mono.fromRunnable(() -> {
                                // 打印日志
                                writeAccessLog(gatewayLog);
                            }));
                }));
    }

    /**
     * 打印日志
     * @author javadaily
     * @date 2021/3/24 14:53
     * @param gatewayLog 网关日志
     */
    private void writeAccessLog(GatewayLog gatewayLog) {
        System.out.println("about to print accesslog");
        log.info(gatewayLog.toString());
        System.out.println("finished to print accesslog");
    }



    private Route getGatewayRoute(ServerWebExchange exchange) {
        return exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
    }


    /**
     * 请求装饰器，重新计算 headers
     * @param exchange
     * @param headers
     * @param outputMessage
     * @return
     */
    private ServerHttpRequestDecorator requestDecorate(ServerWebExchange exchange, HttpHeaders headers,
                                                       CachedBodyOutputMessage outputMessage) {
        return new ServerHttpRequestDecorator(exchange.getRequest()) {
            @Override
            public HttpHeaders getHeaders() {
                long contentLength = headers.getContentLength();
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.putAll(super.getHeaders());
                if (contentLength > 0) {
                    httpHeaders.setContentLength(contentLength);
                } else {
                    // TODO: this causes a 'HTTP/1.1 411 Length Required' // on
                    // httpbin.org
                    httpHeaders.set(HttpHeaders.TRANSFER_ENCODING, "chunked");
                }
                return httpHeaders;
            }

            @Override
            public Flux<DataBuffer> getBody() {
                return outputMessage.getBody();
            }
        };
    }


    /**
     * 记录响应日志
     * 通过 DataBufferFactory 解决响应体分段传输问题。
     */
    private ServerHttpResponseDecorator recordResponseLog(ServerWebExchange exchange, GatewayLog gatewayLog) {
        ServerHttpResponse response = exchange.getResponse();
        DataBufferFactory bufferFactory = response.bufferFactory();

        return new ServerHttpResponseDecorator(response) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                if (body instanceof Flux) {
                    Date responseTime = new Date();
                    gatewayLog.setResponseTime(responseTime);
                    // 计算执行时间
                    long executeTime = (responseTime.getTime() - gatewayLog.getRequestTime().getTime());

                    gatewayLog.setExecuteTime(executeTime);

                    // 获取响应类型，如果是 json 就打印
                    String originalResponseContentType = exchange.getAttribute(ServerWebExchangeUtils.ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR);


                    /*if (this.getStatusCode().value() == HttpStatus.OK.value()
                            && originalResponseContentType != null && originalResponseContentType != ""
                            && originalResponseContentType.contains("application/json")) {
                    *//*if (ObjectUtil.equal(this.getStatusCode(), HttpStatus.OK)
                            && StringUtil.isNotBlank(originalResponseContentType)
                            && originalResponseContentType.contains("application/json")) {*//*

                        Flux<? extends DataBuffer> fluxBody = Flux.from(body);
                        return super.writeWith(fluxBody.buffer().map(dataBuffers -> {

                            // 合并多个流集合，解决返回体分段传输
                            DataBufferFactory dataBufferFactory = new DefaultDataBufferFactory();
                            DataBuffer join = dataBufferFactory.join(dataBuffers);
                            byte[] content = new byte[join.readableByteCount()];
                            join.read(content);

                            // 释放掉内存
                            DataBufferUtils.release(join);
                            String responseResult = new String(content, StandardCharsets.UTF_8);



                            gatewayLog.setResponseData(responseResult);

                            return bufferFactory.wrap(content);
                        }));
                    }*/
                    Flux<? extends DataBuffer> fluxBody = Flux.from(body);
                    return super.writeWith(fluxBody.buffer().map(dataBuffers -> {

                        // 合并多个流集合，解决返回体分段传输
                        DataBufferFactory dataBufferFactory = new DefaultDataBufferFactory();
                        DataBuffer join = dataBufferFactory.join(dataBuffers);
                        byte[] content = new byte[join.readableByteCount()];
                        join.read(content);

                        // 释放掉内存
                        DataBufferUtils.release(join);
                        String responseResult = new String(content, StandardCharsets.UTF_8);



                        gatewayLog.setResponseData(responseResult);

                        return bufferFactory.wrap(content);
                    }));
                }
                // if body is not a flux. never got there.
                return super.writeWith(body);
            }
        };
    }
}