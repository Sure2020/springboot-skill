/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TC
 * Date Created : 2023-07-08
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-07-08       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @program: com.example.test.controller
 * @description: xxx
 * @author: w15021
 * @create: 2023-07-08
 **/
@Slf4j
@RestController
public class TC {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private ThreadPoolTaskExecutor executor;

    private static JSONObject obj = new JSONObject();

    static {
        obj.put("id", "abc");
        obj.put("name", "dev_a");
        obj.put("msg", "test");
        obj.put("testcode", 2000);
        obj.put("requestId", "abc_requestId");
        obj.put("code", 200);
        obj.put("message", "success");
        obj.put("data", "congratulations");
    }

    @PostMapping("/test/async")
    public String testAsync(@RequestBody JSONObject requestObj) {
        String url = requestObj.getString("url");
        CompletableFuture.runAsync(() -> pushMessage(1, obj, url), executor);
        return "test async";
    }

    public void pushMessage(int count, JSONObject param, String testurl) {
        //String pushUrl = System.getenv("PUSH_URL");
        String pushUrl = testurl;
        if (pushUrl == null) {
            log.error("无推送地址");
            return;
        }
        log.info("PUSH_URL from env: {}", pushUrl);
        List<String> pushUrlList = Arrays.asList(pushUrl.split(";"));
        log.info("pushUrlList: {}", pushUrlList);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.valueOf("application/json;charset=UTF-8")));
        headers.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));
        HttpEntity<JSONObject> entity = new HttpEntity<>(param, headers);
        for (String url : pushUrlList) {
            log.info("push url: {}", url);
            ResponseEntity<JSONObject> responseEntity = null;
            try {
                responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, JSONObject.class, param);
            } catch (Exception e) {
                log.error("error in async: " + e.getMessage());
                e.printStackTrace();
            }
            log.info("status code: {}  body: {}", responseEntity.getStatusCodeValue(), responseEntity.getBody().toString());

            /*log.info("another test");
            HttpClientResult responseEntity2 = HttpClientPoolUtils.getPostResult(url, "application/json", param, null);
            log.info(count + "次调用执行成功" + responseEntity2);*/
        }
    }
}