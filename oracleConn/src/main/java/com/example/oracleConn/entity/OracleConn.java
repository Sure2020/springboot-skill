/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : OracleConn
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

package com.example.oracleConn.entity;

/**
 * @program: com.example.oracleConn.entity
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-26
 **/
public class OracleConn {
    String url = "jdbc:oracle:thin:@localhost:1521:ORCL"; // 主机:端口:SID
    String username = "your_username";
    String password = "your_password";
    String table = "your_tablename";
    String column = "your_column";
    String sql = "";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return "OracleConn{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", table='" + table + '\'' +
                ", column='" + column + '\'' +
                '}';
    }
}