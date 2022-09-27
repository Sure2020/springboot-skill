/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : HeaderController
 * Date Created : 2022-09-27
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-09-27       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.get_header_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @program: com.example.get_header_demo
 * @description: xxx
 * @author: w15021
 * @create: 2022-09-27
 **/
@RestController
public class HeaderController {
    @GetMapping("/header")
    public void printHeader (HttpServletRequest request) {
        Enumeration<String> e = request.getHeaderNames();
        while(e.hasMoreElements()){
            String headerName = e.nextElement();
            Enumeration<String> headerValues = request.getHeaders(headerName);
            while(headerValues.hasMoreElements()){
                System.out.println(headerName+":"+headerValues.nextElement());
            }
        }
    }
}