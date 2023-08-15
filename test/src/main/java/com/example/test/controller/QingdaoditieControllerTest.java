/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : QingdaoditieControllerTest
 * Date Created : 2023-08-03
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-08-03       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: com.example.test.controller
 * @description: xxx
 * @author: w15021
 * @create: 2023-08-03
 **/
@RestController
@Slf4j
public class QingdaoditieControllerTest {
    @PostMapping({
            "/ims/heartbeat/update",
            "/ims/operation/update",
            "/ims/service/status/update",
            "/ims/device/update",
            "/ims/device/status/update"})
    public String zte(@RequestBody JSONObject requestObj, HttpServletRequest httpServletRequest) {
        log.info("************************  post  *********************");
        log.info("httpServletRequest: {}", httpServletRequest.getRequestURL().toString());
        log.info(httpServletRequest.getQueryString());
        log.info(requestObj.toString());
        return "ok";
    }


}