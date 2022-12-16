/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : WebMvcConfig
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

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置接口只有携带token才可以访问的路劲
        registry.addInterceptor(myInterceptor).addPathPatterns("/token/**");
    }
}
