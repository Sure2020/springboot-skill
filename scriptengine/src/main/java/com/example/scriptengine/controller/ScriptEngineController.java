/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ScriptEngineController
 * Date Created : 2023-04-21
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-04-21       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.scriptengine.controller;

import com.alibaba.fastjson.JSONObject;

import static com.example.scriptengine.util.JsUtil.changeHeaderParams;

/**
 * @program: com.example.scriptengine.controller
 * @description: xxx
 * @author: w15021
 * @create: 2023-04-21
 **/
public class ScriptEngineController {
    public static void main(String[] args) throws Exception {
        System.out.println("test script engine");
        String scriptString = "  function changeHeaderParams(jsonObject) {\n" +
                "    var res_body = JSON.parse(jsonObject);\n" +
                "    var result = {'method':'GET','url':res_body};\n" +
                "    return JSON.stringify(result);\n" +
                " }";
        String scriptString2 = "fetch('http://192.168.110.228:8123/qingdao/token', {\n" +
                "    method: 'POST',\n" +
                "    headers: {\n" +
                "        'Content-Type': 'application/json'\n" +
                "    },\n" +
                "    body: JSON.stringify({key1: 'value1', key2: 'value2'})\n" +
                "})\n" +
                "    .then(response => response.text())\n" +
                "    .then(data => console.log(data))\n" +
                "    .catch(error => console.error(error));";
        String scriptString3 = "const xhr = new XMLHttpRequest();\n" +
                "const url = 'http://192.168.110.228:8123/qingdao/token';\n" +
                "const data = JSON.stringify({ key: 'value' });\n" +
                "\n" +
                "xhr.open('POST', url);\n" +
                "xhr.setRequestHeader('Content-Type', 'application/json');\n" +
                "\n" +
                "xhr.onreadystatechange = function() {\n" +
                "    if (xhr.readyState === 4 && xhr.status === 200) {\n" +
                "        console.log(xhr.responseText);\n" +
                "    }\n" +
                "};\n" +
                "\n" +
                "xhr.send(data);";
        String scriptString4 = "function changeHeaderParams(jsonObject) {\n" +
                "    fetch('http://192.168.110.228:8123/qingdao/token', {\n" +
                "        method: 'POST',\n" +
                "        headers: {\n" +
                "            'Content-Type': 'application/json'\n" +
                "        },\n" +
                "        body: JSON.stringify({key1: 'value1', key2: 'value2'})\n" +
                "    })\n" +
                "        .then(function(response) {\n" +
                "            return response.text();\n" +
                "        })\n" +
                "        .then(function(data) {\n" +
                "            console.log(data);\n" +
                "        })\n" +
                "        .catch(function(error) {\n" +
                "            console.error(error);\n" +
                "        });\n" +
                "}";
        JSONObject requestObj = new JSONObject();
        requestObj.put("key", "value");
        JSONObject resultObj = changeHeaderParams(scriptString4, requestObj );
        System.out.println(resultObj.toJSONString());
    }
}