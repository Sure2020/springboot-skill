/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestBasicAuth
 * Date Created : 2023-03-16
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-03-16       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.basicauth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @program: com.example.basicauth.controller
 * @description: 参考自  https://www.jianshu.com/p/af16389888cb
 * @author: w15021
 * @create: 2023-03-16
 **/
@RestController
public class TestBasicAuth {
    /*@Autowired
    RestTemplate restTemplate;*/
    @GetMapping("/get")
    public String testBasicAuth(){
        //String testurl = "http://39.103.230.93:8010/oasisDataRerorting/ReceiveReportedData";
        //String testurl = "http://localhost:1289/post";
        String testurl = "http://192.168.110.228:8123/api/v2/post/dali";
        //即使这里设置了认证信息，请求的是不带认证的接口，也可以
        RestTemplate restTemplate = new RestTemplateBuilder()
                .basicAuthentication("dataReport", "Aa12345678")
                .build();
        HttpHeaders httpHeaders = new HttpHeaders();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("key", "value");
        //HttpEntity<ObjectNode> entity = new HttpEntity<>(objectNode, httpHeaders);
        HttpEntity<String> entity = new HttpEntity<>("I am body", httpHeaders);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<Object> responseEntity =
                restTemplate.postForEntity(testurl, entity, Object.class);
        System.out.println(responseEntity.getStatusCode());
        return "ok";
    }
    @PostMapping("/post")
    public String testPost () {
        return "{\"a\":\"b\"}";
    }
    @GetMapping("/get2")
    public String test2(){
        String testurl = "http://39.103.230.93:8010/oasisDataRerorting/ReceiveReportedData";
        //即使这里设置了认证信息，请求的是不带认证的接口，也可以
        /*ClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);*/

        RestTemplate restTemplate = new RestTemplateBuilder()
                .basicAuthentication("dataReport", "Aa12345678")
                .build();
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter =
                new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        HttpHeaders httpHeaders = new HttpHeaders();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("key", "value");
        //HttpEntity<ObjectNode> entity = new HttpEntity<>(objectNode, httpHeaders);
        HttpEntity<String> entity = new HttpEntity<>("I am body", httpHeaders);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<Object> responseEntity =
                restTemplate.postForEntity(testurl, entity, Object.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.toString());
        return "ok";
    }
}