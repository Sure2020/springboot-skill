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

import java.sql.*;
import java.util.Properties;

import static com.example.template.config.Contant.*;

/**
 * @program: com.example.template
 * @description: xxx
 * @author: w15021
 * @create: 2024-05-11
 **/
public class TDengineConnectDemo_DROP {
    public void tdconn() {
        System.out.println("testing");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        //String jdbcUrl = "jdbc:TAOS://vm124:6030?user=root&password=taosdata";
        String jdbcUrl = String.format("jdbc:TAOS://%s:%d?user=%s&password=%s",
                HOST,PORT,USERNAME,PASSWORD);
        System.out.println(jdbcUrl);
        Properties connProps = new Properties();
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_CHARSET, "UTF-8");
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_LOCALE, "en_US.UTF-8");
        connProps.setProperty(TSDBDriver.PROPERTY_KEY_TIME_ZONE, "UTC-8");
        try {
            connection = DriverManager.getConnection(jdbcUrl, connProps);
            System.out.println("Connected");
            // 执行 SQL 查询
            statement = connection.createStatement();
            String sqlQuery = "select * from admin_settings";
            resultSet = statement.executeQuery(sqlQuery);

            // 处理结果集
            while (resultSet.next()) {
                System.out.println("Column 1: " + resultSet.getString(1));
                System.out.println("Column 2: " + resultSet.getString(2));
                // 在此添加你需要处理的其他列
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭连接
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}