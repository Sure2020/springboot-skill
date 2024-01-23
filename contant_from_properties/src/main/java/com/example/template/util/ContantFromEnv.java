/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ContantFromEnv
 * Date Created : 2024-01-23
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-23       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @program: com.example.template.util
 * @description: xxx
 * @author: w15021
 * @create: 2024-01-23
 **/
@Slf4j
public class ContantFromEnv {
    private String XYZ_str;
    private int ABC_int;
    private long MNT_long;
    public ContantFromEnv(){
        //String variableName = "XYZ";
        // 获取所有环境变量
        Map<String, String> envVariables = System.getenv();

        // 判断是否存在指定的环境变量
        if (envVariables.containsKey("XYZ")) {
            log.info("yes");
            String variableValue = envVariables.get("XYZ");
            setXYZ_str(variableValue);
        } else {
            log.info("no");
            setXYZ_str("default");
        }
        if (envVariables.containsKey("ABC")) {
            log.info("yes");
            setABC_int(Integer.parseInt(envVariables.get("ABC")));
        } else {
            log.info("no");
            setABC_int(100);
        }
        if (envVariables.containsKey("MNT")) {
            log.info("yes");
            setMNT_long(Long.parseLong(envVariables.get("MNT")));
        } else {
            log.info("no");
            setMNT_long(100L);
        }

    }

    public String getXYZ_str() {
        return XYZ_str;
    }

    public void setXYZ_str(String XYZ_str) {
        this.XYZ_str = XYZ_str;
    }

    public int getABC_int() {
        return ABC_int;
    }

    public void setABC_int(int ABC_int) {
        this.ABC_int = ABC_int;
    }

    public long getMNT_long() {
        return MNT_long;
    }

    public void setMNT_long(long MNT_long) {
        this.MNT_long = MNT_long;
    }
}