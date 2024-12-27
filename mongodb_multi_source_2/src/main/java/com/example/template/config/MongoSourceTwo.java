/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MongoSourceTwo
 * Date Created : 2024-12-27
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-12-27       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @program: com.example.template.config
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-27
 **/

@Configuration
//@EnableMongoRepositories(basePackages = {"com.h3c.wbc.acpoolmonitor.infrastructure.repository"},mongoTemplateRef = "ywApinfoMongoTemplate")
public class MongoSourceTwo {

    @Value("${spring.data.mongodb.ywapinfouri}")
    private String ywApinfoUri;

    @Bean("mongoClient2")
    public MongoClient mongoClient() {
        return MongoClients.create(ywApinfoUri);
    }

    @Bean("ywApinfoMongoTemplate")
//    @Primary
    public MongoTemplate mongoTemplate(@Qualifier("mongoClient2") MongoClient mongoClient) throws Exception {
        System.out.println("创建mongoTemplate");
        return new MongoTemplate(mongoClient, "acpool2"); // 替换为你的数据库名称
    }
}