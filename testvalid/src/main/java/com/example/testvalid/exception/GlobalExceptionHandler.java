/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : GlobalExceptionHandler
 * Date Created : 2022-09-15
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-09-15       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.testvalid.exception;

//import org.apache.catalina.connector.Response;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.example.testvalid.exception
 * @description: xxx
 * @author: w15021
 * @create: 2022-09-15
 **/

/**
 * @RestControllerAdvice与@ControllerAdvice的区别
 *
 * 简单地说，@RestControllerAdvice与@ControllerAdvice的区别就和@RestController与@Controller的区别类似，@RestControllerAdvice注解包含了@ControllerAdvice注解和@ResponseBody注解。
 *
 *
 *
 * 当自定义类加@ControllerAdvice注解时，方法需要返回json数据时，每个方法还需要添加@ResponseBody注解：
 * ————————————————
 * 版权声明：本文为CSDN博主「幸运小男神」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/hyk521/article/details/104990636
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NullPointerException.class, RuntimeException.class, ClassCastException.class,
            IOException.class, IndexOutOfBoundsException.class, HttpRequestMethodNotSupportedException.class})
    public String handle(Exception ex) {
        System.out.println(ex.getMessage());
        return ex.getMessage();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class,
            MissingServletRequestParameterException.class})
    public MyResponse handleValidated(Exception ex) {
        System.out.println(ex.getMessage());

        return new MyResponse(ex.getMessage(), -1);
    }


}