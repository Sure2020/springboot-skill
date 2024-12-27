/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
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

package com.example.template.controller;

import com.example.template.entity.Table1;
//import com.example.template.repository.YourEntityRepository;
import com.example.template.repository.YourEntityRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @program: com.example.template.controller
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-27
 **/
@RestController
public class TestController {
    @Autowired
    YourEntityRepository yourEntityRepository;

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    @Qualifier("ywApinfoMongoTemplate")
    MongoTemplate ywApinfoMongoTemplate;
    @GetMapping("/test")
    public String test(){
        //Table1 table1 = mongoTemplate.findById("a", Table1.class);
        List<Table1> table1List = mongoTemplate.findAll(Table1.class,"table1");
        System.out.println(table1List.size());
        System.out.println("testing");

        Table1 table1 = yourEntityRepository.findByName("b");
        System.out.println(table1.toString());

        Table1 table11 = mongoTemplate.findById("676e5826760116692abd0060", Table1.class);
        System.out.println(table11.toString());
        System.out.println("###############");

        List<Table1> table1List2 = ywApinfoMongoTemplate.findAll(Table1.class,"table3");
        System.out.println(table1List2.size());
        System.out.println(table1List2.get(0).toString());


        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("b"));  // 添加查询条件
        List<Table1> table1List3 = mongoTemplate.find(query, Table1.class);  // 执行查询
        System.out.println(table1List3.size());
        System.out.println(table1List3.get(0).toString());
        return "testing";
    }

    @Autowired
    private MongoClient mongoClient;
    @GetMapping("/test2")
    // 有效果
    public String test2(){
        System.out.println("所有数据库：");
        MongoIterable<String> databaseNames = mongoClient.listDatabaseNames();
        for (String dbName : databaseNames) {
            System.out.println("- " + dbName);
        }
        return "testing";
    }

    @GetMapping("/test3")
    public String test3(){
        Set<String> collectionNames = mongoTemplate.getCollectionNames();
        System.out.println("当前数据库中的集合：");
        for (String collectionName : collectionNames) {
            System.out.println("- " + collectionName);
        }

        MongoDatabase db = mongoTemplate.getDb();
        Document stats = db.runCommand(new Document("dbStats", 1));
        System.out.println("当前数据库信息：");
        System.out.println(stats.toJson());


        MongoDatabase db2 = mongoTemplate.getDb();
        Document stats2 = db2.runCommand(new Document("collStats", "table1"));
        System.out.println("table1" + " 集合的统计信息：");
        System.out.println(stats2.toJson());


        MongoDatabase db3 = mongoTemplate.getDb();
        Document status3 = db3.runCommand(new Document("serverStatus", 1));
        System.out.println("服务器状态：");
        System.out.println(status3.toJson());


        return "testn";
    }
}