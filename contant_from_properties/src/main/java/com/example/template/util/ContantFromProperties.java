/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ContantFromProperties
 * Date Created : 2024-01-22
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-22       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: com.example.template.util
 * @description: xxx
 * @author: w15021
 * @create: 2024-01-22
 **/
@Component
public class ContantFromProperties {
    private static String abc;
    private static String xyz;

    public static String getAbc() {
        return abc;
    }

    @Value("${a.b.c}")
    public void setAbc(String abc) {
        this.abc = abc;
    }

    public static String getXyz() {
        return xyz;
    }
    @Value("${x.y.z}")
    public void setXyz(String xyz) {
        this.xyz = xyz;
    }
}