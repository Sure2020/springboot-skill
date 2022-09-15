/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MyResponse
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

/**
 * @program: com.example.testvalid.exception
 * @description: xxx
 * @author: w15021
 * @create: 2022-09-15
 **/

public class MyResponse {
    private String message;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MyResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public MyResponse() {
    }
}