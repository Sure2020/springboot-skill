/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
 * Date Created : 2024-03-09
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-09       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.example.template.controller
 * @description: xxx
 * @author: w15021
 * @create: 2024-03-09
 **/
@RestController
public class TestController {
    @GetMapping("/getById/{userId}")
    public String getById() throws Exception {
        // 手动抛出异常
        //java.lang.ArithmeticException: / by zero
        //throw new Exception("a");
        int a = 10/0;
        return "testing";
    }
}