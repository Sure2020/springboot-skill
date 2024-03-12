/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
 * Date Created : 2024-03-11
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-11       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.controller;

/**
 * @program: com.example.template.controller
 * @description: xxx
 * @author: w15021
 * @create: 2024-03-11
 **/


import com.example.template.service.JdbcExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class TestController {
    @Autowired
    JdbcExample jdbcExample;
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String index() {
        jdbcExample.fetchData();
        return "testing";
    }
    @RequestMapping(value="/exit", method=RequestMethod.GET)
    public void exit() {
        System.out.println("exit");
        System.exit(-111);
    }
}

