/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
 * Date Created : 2022-12-16
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-12-16       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.example.filter.controller
 * @description: xxx
 * @author: w15021
 * @create: 2022-12-16
 **/
@RestController
public class TestController {
    @GetMapping("/filter/get")
    public String filterGet (){

        return "filter get";
    }
    @PostMapping("/filter/post")
    public String filterPost (){

        return "filter post";
    }
}