/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
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

package com.example.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.test.config.ConfigurationPropertiesTest;
import com.example.test.main.Testmember;
import com.example.test.util.InfoSingleton;
import com.example.test.util.TestAsync;
import com.example.test.util.Tools;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.Map;
//import org.apache.commons.io.IOUtils;

import static com.example.test.util.Tools.mySleep;

/**
 * @program: com.example.test.controller
 * @description: xxx
 * @author: w15021
 * @create: 2022-12-19
 **/
@RestController
@Slf4j
public class TestController {
    @Autowired
    private TestAsync testAsync;
    @Autowired
    ConfigurationPropertiesTest configurationPropertiesTest;
    /*private RestTemplate restTemplate = new RestTemplate();
    @PostConstruct
    public void init() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(10000);
        requestFactory.setReadTimeout(10000);
        restTemplate = new RestTemplate(requestFactory);
    }*/

    private static JSONObject jsonObject = new JSONObject();
    private static JSONObject jsonObjectDali = new JSONObject();
    static {
        jsonObject.put("wfs","wfs");

        jsonObjectDali.put("code",200);
        jsonObjectDali.put("description","OK");
    }
    private static JSONObject obj = new JSONObject();
    static {
        obj.put("code", 200);
        obj.put("message", "testing");
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("id", "testdev");
        obj.put("data", jsonObject1);
    }
    @PostMapping("/test/post")
    public JSONObject testPost(@RequestBody JSONObject requestObj){
        System.out.println("***************post*************");
        System.out.println(requestObj.toString());

        return obj;
    }


    @GetMapping("/api/get")
    public Object apiGet(HttpServletRequest request){
        System.out.println(request.getPathInfo());
        System.out.println(request.getPathTranslated());
        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());
        System.out.println(request.getServletPath());
        Map<String, String[]> parameters = request.getParameterMap();
        for (String parameterName : parameters.keySet()) {
            String[] parameterValues = parameters.get(parameterName);
            for (String parameterValue : parameterValues) {
                System.out.println(parameterName + ": " + parameterValue);
            }
        }

        //return "api get";
        return jsonObject;
    }
    @PostMapping("/api/v2/post")
    public JSONObject apiPost(){
        //return "api post";
        return jsonObject;
    }

    @PostMapping("/api/v2/post/dali")
    public JSONObject apiPostDali(){
        //return "api post";
        return jsonObjectDali;
    }

    @PostMapping("/qingdao/token")
    public JSONObject qingdaoToken(@RequestBody JSONObject requestObj){
        System.out.println(requestObj.toJSONString());
        //return "api post";
        JSONObject tokenObj = new JSONObject();
        JSONObject resultObj = new JSONObject();
        resultObj.put("token", "abcxxxuyyyzzzz");
        tokenObj.put("code",0);
        tokenObj.put("massage","success");
        tokenObj.put("result", resultObj);
        return tokenObj;
    }
    @GetMapping("/test/async/progress")
    public void testAsync() throws InterruptedException {

        log.info("get progress begin");

        InfoSingleton infoSingleton = InfoSingleton.getInstance();

        int count = 10;
        for (int i = 0; i <count; i++) {
            mySleep("progess", 1);
            log.info(infoSingleton.getIsExtracting().toString());
        }


        log.info("get progress end");
    }

    @GetMapping("/test/async/update")
    public void testAsyncExtract() throws InterruptedException {

        testAsync.testLogAsync();
    }

    @GetMapping("/test/ConfigurationPropertiesTest")
    public String testConfigurationPropertiesTest () {
        log.info(configurationPropertiesTest.getA()+ configurationPropertiesTest.getB());
        return "configurationPropertiesTest";
    }

    @GetMapping("/test/id/id2")
    public String testidid2(){
        Testmember t = new Testmember();
        t.setId("a");
        System.out.println(t.toString());
        return t.toString();
    }
    @GetMapping("/test/restTemplate")
    public String testRestTemplate(){
        Testmember t = new Testmember();
        t.setId("a");
        Testmember t2 = new Testmember();
        t2.setId("b");
        List<Testmember> testmemberList = new ArrayList<>();
        testmemberList.add(t);
        testmemberList.add(t2);
        String url = "http://localhost:18989/test/post";
        sendRequest(url, testmemberList);
        sendRequest(url, t);
        sendRequest(url, obj);
        System.out.println(t.toString());
        return t.toString();
    }

    public <T> String sendRequest(String url, T body){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<T> entity = new HttpEntity<>(body, headers);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, entity, Object.class);
        System.out.println(response);
        return "testing";
    }

    @GetMapping("/test/pinbo")
    public Object testPinbo(){
        String url = "http://60.191.74.30:19080/platform-boot/data/list?locateTime_end=2023-10-30 20:00:00&locateTime_begin=2023-10-30 00:00:00&pageNo=1&pageSize=1";

// create an instance of RestTemplate

// create headers
        HttpHeaders headers = new HttpHeaders();

// set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));


// example of custom header
        headers.set("X-Access-Token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTg5NzEwMDgsInVzZXJuYW1lIjoiYWRtaW4ifQ.qZyW3ZDwDr7advbkB_6DzdW0BVlknAeebjocTayY5mA");

// build the request
        HttpEntity request = new HttpEntity(headers);
        ResponseErrorHandler responseErrorHandler = new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return true;
            }
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
            }
        };
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(responseErrorHandler);

// make an HTTP GET request with headers
        ResponseEntity<Object> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                Object.class,
                1
        );

// check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed");
            System.out.println(response.getBody());
            System.out.println(response.getStatusCode());
        }
        return response.getBody();
    }

    @GetMapping("/big/data/{count}")
    public Object bigData(@PathVariable("count") int count, HttpServletResponse response){
        response.addHeader("a", "a");
        response.addHeader("a", "a");
        response.setHeader("Access-Control-Allow-Origin", "test");
        response.setHeader("Content-Type","text/plain");
        StringBuilder sb = new StringBuilder();
        sb.append("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTg5NzEwMDgsInVzZXJuYW1lIjoiYWRtaW4ifQ.qZyW3ZDwDr7advbkB_6DzdW0BVlknAeebjocTayY5mA");
        JSONObject jsonObject = new JSONObject();
        for (int i = 1; i<count; i++){
            jsonObject.put(String.valueOf(i), sb);
        }
        return jsonObject;
    }

}