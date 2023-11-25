/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
 * Date Created : 2023-10-26
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-26       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.oracleConn.controller;

import com.example.oracleConn.entity.OracleConn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * @program: com.example.oracleConn.controller
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-26
 **/
@RestController
@Slf4j
public class TestController {
    @PostMapping("/test/oracle")
    public void testOracleConn(@RequestBody OracleConn oracleConn){
        // JDBC连接URL，根据你的Oracle数据库配置修改以下信息
        /*String url = "jdbc:oracle:thin:@localhost:1521:ORCL"; // 主机:端口:SID
        String username = "your_username";
        String password = "your_password";
        String table = "";*/
        String url = oracleConn.getUrl();
        String username = oracleConn.getUsername();
        String password = oracleConn.getPassword();
        String table = oracleConn.getTable();
        String column = oracleConn.getColumn();
        System.out.println(oracleConn.toString());

        try {
            // 加载Oracle JDBC驱动程序
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            Connection connection = DriverManager.getConnection(url, username, password);

            // 创建一个SQL语句执行对象
            Statement statement = connection.createStatement();

            // 执行SQL查询
            String sqlQuery = "SELECT * FROM " + table;
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // 处理查询结果
            while (resultSet.next()) {
                String column1 = resultSet.getString(column);
                //String column2 = resultSet.getString("column2");
                // 在此处处理结果
                System.out.println(column1);
            }

            // 关闭资源
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/test/oracle2")
    public void testOracleConn2(@RequestBody OracleConn oracleConn){
        String url = oracleConn.getUrl();
        String username = oracleConn.getUsername();
        String password = oracleConn.getPassword();
        String table = oracleConn.getTable();
        String column = oracleConn.getColumn();
        String sql = oracleConn.getSql();
        System.out.println(oracleConn.toString());
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, Object> resultMap = new HashMap<>();
        hashMap.put("url", url);
        hashMap.put("username", username);
        hashMap.put("password", password);
        hashMap.put("tableName", table);

        Connection conn = null;
        try {
            log.info("begin to connect oracle");
            log.info("url:"+hashMap.get("url")+"--"+hashMap.get("username")+":"+hashMap.get("password"));
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(hashMap.get("url"), hashMap.get("username"),hashMap.get("password"));
            //ResultSet resultSet = conn.prepareStatement("select count(1) from " + hashMap.get("tableName")).executeQuery();
            System.out.println(System.currentTimeMillis());
            ResultSet resultSet = conn.prepareStatement(sql).executeQuery();
            System.out.println(System.currentTimeMillis());
            while (resultSet.next()) {
                String column1 = resultSet.getString(column);
                //String column2 = resultSet.getString("column2");
                // 在此处处理结果
                System.out.println(column1);
            }
            System.out.println(conn);
            resultMap.put("flag",true);
            resultMap.put("desc","数据库连接成功!");
        } catch (Exception e) {
            log.error("数据库连接异常");
            e.printStackTrace();
            String message = e.toString();
            if(message.contains("ORA-01017")){
                resultMap.put("desc","数据库连接失败，请检查用户名或密码！");
            }else if(message.contains("SQLRecoverableException") && message.contains("The Network Adapter could not establish the connection")){
                resultMap.put("desc","数据库连接失败，请检查IP和PORT是否输入正确！");
            }else{
                resultMap.put("desc","数据库连接失败，配置错误请检查!");
            }
            resultMap.put("flag",false);
            //return resultMap;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                log.info("conn 关闭异常");
            }
        }
    }

    @PostMapping("/test/oracle/meta")
    public void getOracleMetadata(@RequestBody OracleConn oracleConn){
        // JDBC连接URL，根据你的Oracle数据库配置修改以下信息
        /*String url = "jdbc:oracle:thin:@localhost:1521:ORCL"; // 主机:端口:SID
        String username = "your_username";
        String password = "your_password";
        String table = "";*/
        String url = oracleConn.getUrl();
        String username = oracleConn.getUsername();
        String password = oracleConn.getPassword();
        String table = oracleConn.getTable();
        //String column = oracleConn.getColumn();
        System.out.println(oracleConn.toString());

        try {
            // 加载Oracle JDBC驱动程序
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            Connection connection = DriverManager.getConnection(url, username, password);

            DatabaseMetaData metaData = connection.getMetaData();

            // 指定要获取结构信息的表名和模式（可以为null，表示使用默认模式）
            String schema = null;

            // 获取表的结构信息
            ResultSet resultSet = metaData.getColumns(null, schema, table, null);

            // 打印表的结构信息
            while (resultSet.next()) {
                String columnName = resultSet.getString("COLUMN_NAME");
                String dataType = resultSet.getString("TYPE_NAME");
                int columnSize = resultSet.getInt("COLUMN_SIZE");

                System.out.println("Column Name: " + columnName + ", Data Type: " + dataType + ", Column Size: " + columnSize);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}