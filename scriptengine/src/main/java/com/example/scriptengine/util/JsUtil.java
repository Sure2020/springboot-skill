/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : JsUtil
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

package com.example.scriptengine.util;

/**
 * @program: com.example.scriptengine.util
 * @description: xxx
 * @author: w15021
 * @create: 2023-04-21
 **/



import com.alibaba.fastjson.JSONObject;
import com.example.scriptengine.entity.ScriptThread;
import lombok.extern.slf4j.Slf4j;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.util.*;

/**
 * @author lys1698
 * @date 2019/11/21 14:32
 */
@Slf4j
public class JsUtil {
    private static final String JS_ENGINE_NAME = "nashorn";//"JavaScript";
    private static final Integer JS_MAX_WAITTIME = 10000;
    private static final ScriptEngineManager sem = new ScriptEngineManager();
    private static final ScriptEngine engine = sem.getEngineByName(JS_ENGINE_NAME);

    public static JSONObject changeParams(String svcMethod, String url, String contentType, JSONObject jsonresult, String path, List<String> infos) {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName(JS_ENGINE_NAME);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("svcMethod", svcMethod);
        jsonObject.put("url", url);
        jsonObject.put("contentType", contentType);
        jsonObject.put("body", jsonresult);
        try {
            FileReader fileReader = new FileReader(path);
            engine.eval(fileReader);
            Invocable jsInvoke = (Invocable) engine;
            Object obj2 = jsInvoke.invokeFunction("changeParams", svcMethod, url, jsonresult, infos);
            fileReader.close();
            return JSONObject.parseObject((String) obj2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 校验header里面的js脚本
     *
     * @param jsScript js脚本
     * @param params   请求参数
     * @return 执行结果
     */
    public static JSONObject changeHeaderParams(String jsScript, JSONObject params) throws Exception {
        Object changeHeaderParams = invokeScriptFunction(jsScript, params, "changeHeaderParams");
        return JSONObject.parseObject((String) changeHeaderParams);
    }

    /**
     * 校验query里面的js脚本
     *
     * @param jsScript js脚本
     * @param params   请求参数
     * @return 执行结果
     */
    public static JSONObject changeQueryParams(String jsScript, JSONObject params) throws Exception {
        Object changeQueryParams = invokeScriptFunction(jsScript, params, "changeQueryParams");
        return JSONObject.parseObject((String) changeQueryParams);
    }

    /**
     * 校验body里面的js脚本
     *
     * @param jsScript js脚本
     * @param params   请求参数
     * @return 执行结果
     */
    public static JSONObject changeBodyParams(String jsScript, JSONObject params) throws Exception {
        Object changeBodyParams = invokeScriptFunction(jsScript, params, "changeBodyParams");
        return JSONObject.parseObject((String) changeBodyParams);
    }

    /**
     * 脚本最大等待时间处理
     *
     * @param task 执行脚本线程
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int waitScriptRunning(ScriptThread task) {
        int result = 0;
        long start = System.currentTimeMillis();
        while (true) {
            if (task.isDone()) {//如果脚本执行已经结束
                result = 1;
                break;
            }
            long current = System.currentTimeMillis();
            if (current - start >= JS_MAX_WAITTIME) {//超过脚本执行等待时间还未结束，取消执行，强制关闭线程
                if (!task.isDone()) {
                    result = 2;
                    task.interrupt();
                }
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return result;
    }

    /**
     * 多线程执行脚本，预防脚本中有死循环等不合理代码
     *
     * @param jsScript     js脚本
     * @param params       请求参数
     * @param functionName 执行脚本类型
     * @return
     * @throws Exception
     */
    public static Object invokeScriptFunction(String jsScript, JSONObject params, String functionName) throws Exception {

        final Map map = new HashMap<>();
        ScriptThread scriptThread = new ScriptThread() {
            @Override
            public void execute() {
                try {
                    ScriptEngineManager sem = new ScriptEngineManager();
                    ScriptEngine engine = sem.getEngineByName(JS_ENGINE_NAME);
                    if (engine == null) {
                        throw new Exception(String.format("Script engine not get! No support for script [%s].", JS_ENGINE_NAME));
                    }
                    engine.eval(jsScript);
                    map.put("value", ((Invocable) engine).invokeFunction(functionName, params));
                } catch (Exception e) {
                    map.put("exception", e);
                }
            }
        };
        scriptThread.start();
        int result = waitScriptRunning(scriptThread);
        if (result == 2) {
            log.error("time out");
        }
        Object o = map.get("exception");
        if (o != null) {
            throw (Exception) o;
        }
        return map.get("value");
    }


}

