/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMain
 * Date Created : 2023-08-09
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-08-09       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.qingdaoditie;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import static com.example.qingdaoditie.ZTESignature.generateRequestSignature;

/**
 * @program: com.example.qingdaoditie
 * @description: xxx
 * @author: w15021
 * @create: 2023-08-09
 **/
public class TestMain {
    public static void main(String[] args) {
        String url = "http://221.6.11.62:18905/ims/heartbeat/update";

        JSONObject requestObj = new JSONObject();
        requestObj.put("clientId", "4");
        requestObj.put("line", "1006");

        Long timestamp = System.currentTimeMillis();
        String nonce = UUID.randomUUID().toString().replace("-", "");
        String clientId = "4";

        Map<String, Object> params = new TreeMap<>();
        params.put("clientId", clientId);
        params.put("timestamp", timestamp);
        params.put("nonce", nonce);

        Map<String, Object> requestBodyMap = new HashMap<>();
        try {
            requestBodyMap = JSON.parseObject(requestObj.toString(), Map.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //to do 中兴给的这个demo函数中将body也作为一个参数参与了签名的生成，而文档中没要求body也参与
        String signature = generateRequestSignature(params, requestBodyMap);
        params.put("signature", signature);

        String urlFinal = HttpUtil.urlWithForm(url, params, null, false);
        RestTemplate restTemplate = new RestTemplate();

        // Create the request payload
        /*JSONObject payload = new JSONObject(); // Replace with your actual payload
        payload.put("key","value");*/

        // Create the HTTP Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the request entity
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestObj, headers);

        // Send the POST request

        ResponseEntity<Object> response = restTemplate.exchange(urlFinal, HttpMethod.POST, requestEntity, Object.class);

        // Handle the response
        if (response.getStatusCode() == HttpStatus.OK) {
            Object responseBody = response.getBody();
            System.out.println(responseBody);
            // Process the response body
        } else {
            // Handle errors
        }
    }


}