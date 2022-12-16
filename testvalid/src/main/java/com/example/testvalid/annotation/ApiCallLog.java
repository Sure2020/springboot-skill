/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ApiCallLog
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

import java.lang.annotation.*;

/**
 * @program: com.example.testvalid
 * @description: xxx
 * @author: w15021
 * @create: 2022-12-03
 **/
@Target({ElementType.TYPE_USE,
        ElementType.TYPE,
        ElementType.METHOD,
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.FIELD,
        ElementType.LOCAL_VARIABLE,
        ElementType.PACKAGE,
        ElementType.PARAMETER,
        ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiCallLog {
    String value() default "";
    public boolean isSaveRequestDAta() default true;
}
