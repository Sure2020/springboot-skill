package com.example.template;/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : com.example.template.PostgreSQLDemo
 * Date Created : 2024-05-10
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-05-10       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2024-05-10
 **/
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.template.Contant.HOST;
import static com.example.template.Contant.PORT;

@Configuration
public class PostgreSQLDemo {

    /*@Value("${psql.host}")
    private String host;*/
    public void testconnection() {
        System.out.println("testing");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 加载 PostgreSQL JDBC 驱动程序
            Class.forName("org.postgresql.Driver");

            // 连接数据库
            String url = "jdbc:postgresql://"+HOST+":"+PORT+"/iotware";
            System.out.println("url is: "+url);
            String user = "iotware";
            String password = "iotware";
            connection = DriverManager.getConnection(url, user, password);

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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
