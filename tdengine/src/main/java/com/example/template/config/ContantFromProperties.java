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

package com.example.template.config;

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
    private static String host;
    private static String port;
    private static String database;
    private static String username;
    private static String password;

    public static String getHost() {
        return host;
    }

    @Value("${td.host}")
    public void setHost(String host) {
        ContantFromProperties.host = host;
    }

    public static String getPort() {
        return port;
    }

    @Value("${td.port}")
    public void setPort(String port) {
        ContantFromProperties.port = port;
    }

    public static String getDatabase() {
        return database;
    }

    @Value("${td.database}")
    public void setDatabase(String database) {
        ContantFromProperties.database = database;
    }

    public static String getUsername() {
        return username;
    }

    @Value("${td.username}")
    public void setUsername(String username) {
        ContantFromProperties.username = username;
    }

    public static String getPassword() {
        return password;
    }

    @Value("${td.password}")
    public void setPassword(String password) {
        ContantFromProperties.password = password;
    }
}