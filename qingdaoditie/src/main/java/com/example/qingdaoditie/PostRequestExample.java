/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : PostRequestExample
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

/**
 * @program: com.example.qingdaoditie
 * @description: xxx
 * @author: w15021
 * @create: 2023-08-09
 **/
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class PostRequestExample {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // Create the request payload
        JSONObject payload = new JSONObject(); // Replace with your actual payload
        payload.put("key","value");

        // Create the HTTP Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the request entity
        HttpEntity<Object> requestEntity = new HttpEntity<>(payload, headers);

        // Send the POST request
        String url = "http://localhost:12345/test/post";
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class);

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
