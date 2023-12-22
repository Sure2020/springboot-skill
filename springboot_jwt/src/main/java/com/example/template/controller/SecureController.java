/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : SecureController
 * Date Created : 2023-12-22
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-12-22       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.controller;

/**
 * @program: com.example.template.controller
 * @description: xxx
 * @author: w15021
 * @create: 2023-12-22
 **/

import com.example.template.entity.PinboTrail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * 需要登录后携带JWT才能访问
 */
@RestController
public class SecureController
{

    /**
     * 查询 用户信息，登录后携带JWT才能访问
     */
    @RequestMapping("/secure/getUserInfo")
    public String login(HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute("id");
        String userName = request.getAttribute("userName").toString();
        String password= request.getAttribute("password").toString();
        return "当前用户信息id=" + id + ",userName=" + userName+ ",password=" + password;
    }

    @GetMapping("/platform-boot/targetTrail/tagPlaybackList")
    public Object pinbo(PinboTrail pinboTrail){
        System.out.println(pinboTrail.toString());
        return pinboTrail;
    }
}