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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: com.example.test.controller
 * @description: xxx
 * @author: w15021
 * @create: 2022-12-19
 **/
@RestController
public class TestController {
    private static JSONObject jsonObject = new JSONObject();
    static {
        jsonObject.put("wfs","wfs");
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
}