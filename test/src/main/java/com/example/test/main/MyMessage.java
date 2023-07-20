/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MyMessage
 * Date Created : 2023-05-26
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-05-26       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.main;

/**
 * @program: com.example.test.main
 * @description: xxx
 * @author: w15021
 * @create: 2023-05-26
 **/
public class MyMessage {
    @Override
    public String toString() {
        return "MyMessage{" +
                "msg='" + msg + '\'' +
                '}';
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}