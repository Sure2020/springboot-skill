/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
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
@RestController
public class TestController {
    /*@Autowired
    RestTemplate restTemplate;*/

    public static void getResultOfQingdaoZhongxing(String url, String contentType,
                                                   String httpMethod, JSONObject requestObj,
                                                   List<Map> headerMapList) {
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
        if ("POST".equals(httpMethod.toLowerCase())) {
            //return getPostResult(urlFinal, contentType, requestObj, headerMapList);
        } else {
            System.out.println("getResultOfQingdaoZhongxing do not support {} method now");
        }

    }
    @PostMapping("/test/post")
    public JSONObject testPost(@RequestBody Object requestObj){
        System.out.println("***************post*************");
        System.out.println(requestObj.toString());

        JSONObject obj = new JSONObject();
        obj.put("code", 200);
        obj.put("message", "testing");
        obj.put("data", "");
        return obj;
    }
}