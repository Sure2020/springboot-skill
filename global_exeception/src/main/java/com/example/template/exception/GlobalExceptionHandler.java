/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : GlobalExceptionHandler
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

package com.example.template.exception;

/**
 * @program: com.example.template.exception
 * @description: xxx
 * @author: w15021
 * @create: 2024-03-09
 **/
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // 在这里定义你的异常处理逻辑
        if(e instanceof ArithmeticException){
            System.out.println("java.lang.ArithmeticException: / by zero");
        }
        System.out.println(e.getMessage());
        String exceptionClassName = e.getClass().getName();
        List<String> keywords = Arrays.asList("apple", "banana", "cherry", "Arithmetic");
        boolean containsAny = keywords.stream()
                .anyMatch(exceptionClassName::contains);
        System.out.println(containsAny);
        System.exit(-1);
        System.out.println("####");
        //java.lang.Exception
        //Exception
        //java.lang.Exception
        //java.lang.Exception
        System.out.println(e.getClass().getName());
        System.out.println(e.getClass().getSimpleName());
        System.out.println(e.getClass().getCanonicalName());
        System.out.println(e.getClass().getTypeName());
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
