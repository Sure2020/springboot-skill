/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestPython
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

import org.python.util.PythonInterpreter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @program: com.example.scriptengine.controller
 * @description: xxx
 * @author: w15021
 * @create: 2023-04-24
 **/
public class TestPython {
    public static void main(String[] args) throws Exception {
        // 创建 JavaScript 引擎
//        ScriptEngineManager engineManager = new ScriptEngineManager();
//        ScriptEngine engine = engineManager.getEngineByName("jython");//nashorn

        // 定义 JavaScript 脚本
        String script = "import urllib.parse\n" +
                "import urllib.request\n" +
                "\n" +
                "url = \"http://example.com/api\"\n" +
                "params = {'key1': 'value1', 'key2': 'value2'}\n" +
                "\n" +
                "data = urllib.parse.urlencode(params).encode('utf-8')\n" +
                "\n" +
                "req = urllib.request.Request(url, data, headers={'Content-Type': 'application/json'})\n" +
                "\n" +
                "response = urllib.request.urlopen(req)\n" +
                "\n" +
                "print(response.read().decode('utf-8'))\n" +
                "\n";

        // 执行 JavaScript 脚本
        //engine.eval(script);

        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec(script);
    }
}