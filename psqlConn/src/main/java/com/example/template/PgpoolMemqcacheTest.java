/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : PgpoolMemqcacheTest
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
/**
 * @program: com.example.template
 * @description: xxx
 * @author: w15021
 * @create: 2024-07-25
 **/
public class PgpoolMemqcacheTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.110.124:9999/postgres";
        String user = "postgres";
        String password = "postgres@Admin2.0";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // 创建测试表
            stmt.execute("CREATE TABLE IF NOT EXISTS test_table (id SERIAL PRIMARY KEY, data TEXT);");

            // 插入测试数据
            stmt.execute("INSERT INTO test_table (data) VALUES ('test data');");

            // 执行第一次查询（未命中缓存）
            long startTime = System.nanoTime();
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM test_table;");
            while (rs1.next()) {
                System.out.println("First query result: " + rs1.getString("data"));
            }
            long endTime = System.nanoTime();
            System.out.println("First query duration: " + (endTime - startTime) / 1e6 + " milliseconds");

            // 执行第二次查询（应命中缓存）
            startTime = System.nanoTime();
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM test_table;");
            while (rs2.next()) {
                System.out.println("Second query result: " + rs2.getString("data"));
            }
            endTime = System.nanoTime();
            System.out.println("Second query duration: " + (endTime - startTime) / 1e6 + " milliseconds");

            // 执行第二次查询（应命中缓存）
            startTime = System.nanoTime();
            ResultSet rs3 = stmt.executeQuery("SELECT * FROM test_table;");
            while (rs3.next()) {
                System.out.println("Second query result: " + rs3.getString("data"));
            }
            endTime = System.nanoTime();
            System.out.println("Second query duration: " + (endTime - startTime) / 1e6 + " milliseconds");

            // 执行第二次查询（应命中缓存）
            startTime = System.nanoTime();
            ResultSet rs4 = stmt.executeQuery("SELECT * FROM test_table;");
            while (rs4.next()) {
                System.out.println("Second query result: " + rs4.getString("data"));
            }
            endTime = System.nanoTime();
            System.out.println("Second query duration: " + (endTime - startTime) / 1e6 + " milliseconds");

            // 执行第二次查询（应命中缓存）
            startTime = System.nanoTime();
            ResultSet rs5 = stmt.executeQuery("SELECT * FROM test_table;");
            while (rs5.next()) {
                System.out.println("Second query result: " + rs5.getString("data"));
            }
            endTime = System.nanoTime();
            System.out.println("Second query duration: " + (endTime - startTime) / 1e6 + " milliseconds");

            // 清理测试数据
            //stmt.execute("DROP TABLE IF EXISTS test_table;");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}