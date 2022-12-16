/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ApiCallLogAspect
 * Date Created : 2022-12-03
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-12-03       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.testvalid.annotation;
//import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: com.example.testvalid.annotation
 * @description: xxx
 * @author: w15021
 * @create: 2022-12-03
 **/
@Aspect
@Component
public class ApiCallLogAspect {
    @Pointcut("@annotation(com.example.testvalid.annotation.ApiCallLog)")
    public void logPointCut() {

    }
    @Around("logPointCut()")
    public Object around (ProceedingJoinPoint point) throws Throwable {
        System.out.println("test");
        return "test";
    }
}