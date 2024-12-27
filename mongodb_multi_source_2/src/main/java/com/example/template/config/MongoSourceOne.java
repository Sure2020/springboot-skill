/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MongoSourceOne
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

//import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @program: com.example.template.config
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-27
 **/
@Configuration
//@EnableMongoRepositories(basePackages = {"com.example.template.repository"},mongoTemplateRef = "mongoTemplate")
public class MongoSourceOne {

    @Value("${spring.data.mongodb.primaryuri}")
    private String primaryURI;

    @Bean("mongoClient")
    public MongoClient mongoClient() {
        return MongoClients.create(primaryURI);
    }

    @Bean("mongoTemplate")
//    @Primary
    public MongoTemplate mongoTemplate(@Qualifier("mongoClient") MongoClient mongoClient) throws Exception {
        System.out.println("创建mongoTemplate");
        return new MongoTemplate(mongoClient, "acpool"); // 替换为你的数据库名称
    }

}