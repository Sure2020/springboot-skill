/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ConfigurationPropertiesTest
 * Date Created : 2023-07-21
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-07-21       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: com.example.test.config
 * @description: xxx
 * @author: w15021
 * @create: 2023-07-21
 **/
@Data
@Component
@ConfigurationProperties(prefix = "config.test")
public class ConfigurationPropertiesTest {
    private String a;
    private String b;
}