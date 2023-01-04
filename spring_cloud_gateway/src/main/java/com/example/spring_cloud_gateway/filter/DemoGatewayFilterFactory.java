/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DemoGatewayFilterFactory
 * Date Created : 2022-12-19
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-12-19       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.spring_cloud_gateway.filter;

/**
 * @program: com.example.spring_cloud_gateway.filter
 * @description: xxx
 * @author: w15021
 * @create: 2022-12-19
 **/
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Slf4j
//@Component
public class DemoGatewayFilterFactory extends AbstractGatewayFilterFactory<DemoGatewayFilterFactory.Config> {

    private static final String CACHE_REQUEST_BODY_OBJECT_KEY = "cachedRequestBodyObject";

    public DemoGatewayFilterFactory() {
        super(Config.class);
        log.info("Loaded GatewayFilterFactory [DemoFilter]");
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("enabled");
    }

    @Override
    public GatewayFilter apply(DemoGatewayFilterFactory.Config config) {
        return (exchange, chain) -> {
            if (!config.isEnabled()) {
                return chain.filter(exchange);
            }
            log.info("-----DemoGatewayFilterFactory start-----");
            ServerHttpRequest request = exchange.getRequest();
            //RemoteAddress: [/127.0.0.1:4892]
            log.info("RemoteAddress: [{}]", request.getRemoteAddress());
            //Path: [/api/v2/post]
            log.info("Path: [{}]", request.getURI().getPath());
            //Method: [POST]
            log.info("Method: [{}]", request.getMethod());
            //Body: [{"key":"value"}]
            log.info("Body: [{}]", (String) exchange.getAttribute(CACHE_REQUEST_BODY_OBJECT_KEY));
            log.info("-----test test test-----");
            //9123e1de-1
            log.info(request.getId());
            //POST
            log.info(request.getMethodValue());
            // {}
            log.info(request.getCookies().toString());
            // {name=[yeap]}
            log.info(request.getQueryParams().toString());
            //  /127.0.0.1:8080
            log.info(request.getLocalAddress().toString());
            //[user-agent:"ApiPOST Runtime +https://www.apipost.cn", content-type:"application/json", accept:"*/*", accept-encoding:"gzip, deflate, br", connection:"keep-alive", Host:"localhost:8080", content-length:"15", gateway-env:"springcloud-gateway"]
            log.info(request.getHeaders().toString());
            //  /api/v2/post
            log.info(request.getPath().toString());
            // null
            //log.info(request.getSslInfo().toString());
            //FluxCallable
            log.info(request.getBody().toString());
            log.info("-----DemoGatewayFilterFactory end-----");

            log.info("-----response-----");
            ServerHttpResponse response = exchange.getResponse();
            log.info(response.getRawStatusCode().toString());

            return chain.filter(exchange);
        };
    }

    public static class Config {

        private boolean enabled;

        public Config() {}

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}