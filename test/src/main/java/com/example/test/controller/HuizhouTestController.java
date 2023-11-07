/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : HuizhouTestController
 * Date Created : 2023-08-16
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-08-16       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.test.util.TestJSONEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.example.test.controller
 * @description: xxx
 * @author: w15021
 * @create: 2023-08-16
 **/
@RestController
@Slf4j
public class HuizhouTestController {
    @PostMapping("/test/post/json")
    public JSONObject testPost(@RequestBody TestJSONEntity requestObj){
        System.out.println("***************post*************");
        System.out.println(requestObj.toString());

        Object paramsObject = requestObj.getParams();
        String object = paramsObject.toString();
        System.out.println(object);
        boolean flag = false;
        try{
            JSONObject jsonObject = JSONObject.parseObject(object);
            System.out.println("ok");
            System.out.println(jsonObject.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            try{
                JSONArray jsonArray = JSONArray.parseArray(object);
                System.out.println("ok");
                System.out.println(jsonArray.toJSONString());
                flag = true;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println(flag);
        /*if (object instanceof JSONObject ) {
            System.out.println("jsonobject");
        } else if (object instanceof JSONArray) {
            System.out.println("jsonarry");
        } else {
            System.out.println("not now");
            System.out.println(Object.class);
        }*/

        JSONObject obj = new JSONObject();
        obj.put("code", 200);
        obj.put("message", "testing");
        obj.put("data", "");
        return obj;
    }

    @PostMapping("/test/post/jsonnode")
    public JSONObject testjsonnode(@RequestBody TestJSONEntity requestObj){
        System.out.println("***************post*************");
        System.out.println(requestObj.toString());
        JsonNode jsonNode = requestObj.getObj();
        if (jsonNode instanceof ObjectNode) {
            System.out.println("obj");
            JSONObject jsonObject = JSONObject.parseObject(jsonNode.toString());
            System.out.println(jsonObject);

        } else if (jsonNode instanceof ArrayNode) {
            System.out.println("list");
            JSONArray jsonArray = JSONArray.parseArray(jsonNode.toString());
            System.out.println(jsonArray);
        }

        JSONObject obj = new JSONObject();
        obj.put("code", 200);
        obj.put("message", "testing");
        obj.put("data", "");
        return obj;
    }
}