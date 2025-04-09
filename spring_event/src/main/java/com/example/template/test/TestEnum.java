/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestEnum
 * Date Created : 2024-12-14
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-12-14       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.test;

import lombok.Data;

/**
 * @program: com.example.template.test
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-14
 **/
public enum TestEnum {
    ONE("1"),
    TWO("2"),
    THREE("3");

    private String name;

    TestEnum(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
