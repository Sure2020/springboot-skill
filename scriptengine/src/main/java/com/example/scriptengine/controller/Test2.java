/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Test2
 * Date Created : 2023-04-24
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-04-24       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.scriptengine.controller;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @program: com.example.scriptengine.controller
 * @description: xxx
 * @author: w15021
 * @create: 2023-04-24
 **/
public class Test2 {
    public static void main(String[] args) throws Exception {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");
            String js = "function doSwing(t){var f=new Packages.javax.swing.JFrame(t);f.setSize(400,300);f.setVisible(true);}";
        String js2 = "function doSwing(t){var obj=new Packages.java.net.URL('http://192.168.110.228:8123/qingdao/token');" +
                "var connection = (Packages.java.net.HttpURLConnection) obj.openConnection();" +
                "connection.setRequestMethod(\"POST\");" +
                "connection.setRequestProperty(\"Content-Type\", \"application/json\");" +
                "connection.setDoOutput(true);" +
                "}";
            engine.eval(js2);
            Invocable inv = (Invocable) engine;
            inv.invokeFunction("doSwing", "Scripting Swing");
            //Thread.currentThread().join();
    }
    public static void main2(String[] args) throws Exception {
        String url = "http://192.168.110.228:8123/qingdao/token";

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        // 设置请求方法为 POST
        connection.setRequestMethod("POST");

        // 设置请求头
        connection.setRequestProperty("Content-Type", "application/json");

        // 允许写入请求体
        connection.setDoOutput(true);

        // 构造请求体
        String requestBody = "{\"name\": \"John\", \"age\": 30}";

        // 写入请求体
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(requestBody);
        writer.flush();
        writer.close();

        // 发送请求并获取响应
        int responseCode = connection.getResponseCode();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuffer response = new StringBuffer();

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        // 打印响应
        System.out.println("Response Code: " + responseCode);
        System.out.println("Response Body: " + response.toString());
    }

}