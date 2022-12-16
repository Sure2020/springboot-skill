/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MyInterceptor
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

package com.example.jwt.config;

/**
 * @program: com.example.jwt.config
 * @description: xxx
 * @author: w15021
 * @create: 2022-12-14
 **/

import com.alibaba.fastjson.JSONObject;
import com.example.jwt.entity.CheckResult;
import com.example.jwt.util.JwtUtil;
import com.example.jwt.util.SystemConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
//import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.从Cookie获取token
        String token = getTokenFromCookie(request);
        if (StringUtils.isBlank(token)) {
            // 2.从headers中获取
            token = request.getHeader("token");
        }
        if (StringUtils.isBlank(token)) {
            // 3.从请求参数获取
            token = request.getParameter("token");
        }
        if (StringUtils.isBlank(token)) {
            //输出响应流
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg", "403");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getOutputStream().write(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
            return false;
        }
        // 验证token
        CheckResult checkResult = JwtUtil.validateJWT(token);
        if (checkResult.isSuccess()) {
            // 验证通过
            return true;
        } else {
            if (checkResult.getErrCode().equals(SystemConstant.JWT_ERRCODE_EXPIRE)) {
                //输出响应流
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("msg", SystemConstant.JWT_ERRCODE_EXPIRE);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                response.getOutputStream().write(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
                return false;
            } else if (checkResult.getErrCode().equals(SystemConstant.JWT_ERRCODE_FAIL)) {
                //输出响应流
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("msg", SystemConstant.JWT_ERRCODE_FAIL);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                response.getOutputStream().write(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
                return false;
            }
            //输出响应流
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg", "403");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getOutputStream().write(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
            return false;
        }
    }

    private String getTokenFromCookie(HttpServletRequest request) {
        String token = null;
        Cookie[] cookies = request.getCookies();
        int len = null == cookies ? 0 : cookies.length;
        if (len > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        return token;
    }
}