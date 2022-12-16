/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
 * Date Created : 2022-12-14
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-12-14       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.jwt.controller;

/**
 * @program: com.example.jwt.controller
 * @description: xxx
 * @author: w15021
 * @create: 2022-12-14
 **/

import com.example.jwt.entity.ResultVO;
import com.example.jwt.entity.ResultVOUtil;
import com.example.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
public class TestController {
    @RequestMapping("/login")
    public ResultVO<Object> login() throws IOException {
        // 生成token，token有效时间为30分钟
        String token = JwtUtil.createJWT(String.valueOf(new Date()), "user", 3600000L);
        // 将用户户名和token返回
        return ResultVOUtil.success(token);
    }

    @RequestMapping("/token/admin")
    public ResultVO<Object> token() {
        return ResultVOUtil.success("需要token才可以访问的接口");
    }
}