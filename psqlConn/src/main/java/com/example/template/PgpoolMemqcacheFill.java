/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : PgpoolMemqcacheFill
 * Date Created : 2024-07-25
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-07-25       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
/**
 * @program: com.example.template
 * @description: xxx
 * @author: w15021
 * @create: 2024-07-25
 **/

public class PgpoolMemqcacheFill {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.110.124:9999/postgres";
        String user = "postgres";
        String password = "postgres@Admin2.0";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // 创建测试表
//            stmt.execute("CREATE TABLE IF NOT EXISTS test_table (id SERIAL PRIMARY KEY, data TEXT);");
//
//            // 插入大量数据
//            for (int i = 0; i < 10000; i++) {
//                stmt.execute("INSERT INTO test_table (data) VALUES ('test data " + i + "');");
//            }

            // 执行大量查询以填满缓存
            for (int i = 0; i < 200000; i++) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM test_table WHERE data = 'test data " + new Random().nextInt(10000) + "';");
                while (rs.next()) {
                    // 处理结果集
                    System.out.println(i + "  Query result: " + rs.getString("data"));
                }
            }

            // 清理测试数据
            //stmt.execute("DROP TABLE IF NOT EXISTS test_table;");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}