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
import com.example.test.util.InfoSingleton;
import com.example.test.util.TestAsync;
import com.example.test.util.Tools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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
        obj.put("message", "test success");
        obj.put("data", "");
    }
    @PostMapping("/test/post")
    public JSONObject testPost(@RequestBody JSONObject requestObj){
        System.out.println("***************post*************");
        System.out.println(requestObj.toString());

        return obj;
    }


    @GetMapping("/api/get")
    public String apiGet(HttpServletRequest request){
        System.out.println(request.getPathInfo());
        System.out.println(request.getPathTranslated());
        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());
        System.out.println(request.getServletPath());
        return "api get";
        //return jsonObject;
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
}