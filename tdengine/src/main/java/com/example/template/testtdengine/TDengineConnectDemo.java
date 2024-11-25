/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TDengineConnectDemo
 * Date Created : 2024-05-11
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-05-11       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.testtdengine;

import com.taosdata.jdbc.TSDBDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static com.example.template.config.Contant.*;
import static com.example.template.config.Contant.PASSWORD;

/**
 * @program: com.example.template
 * @description: xxx
 * @author: w15021
 * @create: 2024-05-11
 **/
public class TDengineConnectDemo {
    public void test() {
        //String jdbcUrl = "jdbc:TAOS://vm124:6030?user=root&password=taosdata";
        String jdbcUrl = String.format("jdbc:TAOS://%s:%s?user=%s&password=%s",
                HOST,PORT,USERNAME,PASSWORD);
        Properties connProps = new Properties();
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_CHARSET, "UTF-8");
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_LOCALE, "en_US.UTF-8");
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_TIME_ZONE, "UTC-8");
        try {
            Connection conn = DriverManager.getConnection(jdbcUrl, connProps);
            System.out.println("Connected");
            conn.close();
        } catch (SQLException e) {
            System.out.println("error!");
            e.printStackTrace();
        }
    }
}