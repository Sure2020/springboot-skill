/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestConfig
 * Date Created : 2024-01-22
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-22       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.config;

import com.example.template.util.ContantFromEnv;
import com.example.template.util.ContantFromProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import java.util.Map;

import static com.example.template.util.Contant.ABC;
import static com.example.template.util.Contant.XYZ;

/**
 * @program: com.example.template.config
 * @description: xxx
 * @author: w15021
 * @create: 2024-01-22
 **/
@Configuration
@Slf4j
public class TestConfig {
    /*@Value("${a.b.c}")
    private static String testabc;*/
    /*@PostConstruct
    public void init() {*/
    static {
        System.out.println("config");
        ContantFromEnv contantFromEnv = new ContantFromEnv();
        log.info(contantFromEnv.getXYZ_str());
        log.info(""+contantFromEnv.getABC_int());
        log.info(""+contantFromEnv.getMNT_long());
        /*System.out.println(System.getenv("ABC"));
        System.out.println(System.getenv("XYZ"));*/
//        System.out.println(ContantFromProperties.getAbc());
//        System.out.println(ContantFromProperties.getXyz());
        /*System.out.println(ABC);
        System.out.println(XYZ);*/
    }
}