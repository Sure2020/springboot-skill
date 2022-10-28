/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
 * Date Created : 2022-10-27
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-10-27       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.sure.i18n.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.example.sure.i18n.controller
 * @description: xxx
 * @author: w15021
 * @create: 2022-10-27
 **/
@RestController
public class TestController {
    @GetMapping("/test")
    public String test ()  {
        return "test";
    }
}