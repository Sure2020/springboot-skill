/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Contant
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

package com.example.template.config;

/**
 * @program: com.example.template.util
 * @description: xxx
 * @author: w15021
 * @create: 2024-01-22
 **/
public class Contant {
    public static final String HOST = ContantFromProperties.getHost();
    public static final String PORT = ContantFromProperties.getPort();
    public static final String DATABASE = ContantFromProperties.getDatabase();
    public static final String USERNAME = ContantFromProperties.getUsername();
    public static final String PASSWORD = ContantFromProperties.getPassword();
}