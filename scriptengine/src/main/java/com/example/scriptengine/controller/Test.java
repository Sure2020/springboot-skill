/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Test
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

/**
 * @program: com.example.scriptengine.controller
 * @description: xxx
 * @author: w15021
 * @create: 2023-04-24
 **/
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws Exception {
        // 创建 JavaScript 引擎
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("javascript");//nashorn

        // 定义 JavaScript 脚本
        String script = "var http = require('http')\n" +
                "\n" +
                "var data = JSON.stringify({\n" +
                "    'key':'value'\n" +
                "})\n" +
                "var options = {\n" +
                "    hostname: '192.168.110.228',\n" +
                "    port: 8123,\n" +
                "    path: '/qingdao/token',\n" +
                "    method: 'POST',\n" +
                "    headers: {\n" +
                "        'Content-Type': 'application/json',\n" +
                "        'Content-Length': data.length\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "var req = http.request(options, function(res) {\n" +
                "    //console.log(`状态码: ${res.statusCode}`)\n" +
                "\n" +
                "    res.on('data', function(d) {\n" +
                "        process.stdout.write(d)\n" +
                "    })\n" +
                "})\n" +
                "\n" +
                "req.on('error', function(error) {\n" +
                "    //console.error(error)\n" +
                "})\n" +
                "\n" +
                "req.write(data)\n" +
                "req.end()";

        // 执行 JavaScript 脚本
        engine.eval(script);
    }
}


