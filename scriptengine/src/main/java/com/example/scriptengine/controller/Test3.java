/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Test3
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


        import org.mozilla.javascript.Context;
        import org.mozilla.javascript.Function;
        import org.mozilla.javascript.Scriptable;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;

public class Test3 {
    public static void main(String[] args) throws Exception {
        // 创建 JavaScript 上下文
        Context context = Context.enter();

        // 创建全局对象
        Scriptable global = context.initStandardObjects();

        // 定义 JavaScript 脚本
        String script = "var xhr = new XMLHttpRequest();" +
                "xhr.open('POST', 'http://192.168.110.228:8123/qingdao/token', true);" +
                "xhr.setRequestHeader('Content-Type', 'application/json');" +
                "xhr.onreadystatechange = function() {" +
                "    if (xhr.readyState == 4 && xhr.status == 200) {" +
                "        print(xhr.responseText);" +
                "    }" +
                "};" +
                "var data = JSON.stringify({name: 'John', age: 30});" +
                "xhr.send(data);";

        // 编译 JavaScript 脚本
        Object result = context.evaluateString(global, script, "<cmd>", 1, null);

        // 释放 JavaScript 上下文
        Context.exit();
    }
}

