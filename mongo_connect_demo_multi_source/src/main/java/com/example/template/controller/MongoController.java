/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MongoController
 * Date Created : 2024-12-02
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-12-02       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.controller;

/**
 * @program: com.example.template.controller
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-02
 **/

import com.example.template.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * mongo pool 实列
 * @author coderJim
 * @date 2023-05-15 00:03
 */
@RestController
@RequestMapping("/mongopool")
public class MongoController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Qualifier("twoMongoTemplate")
    @Autowired
    private MongoTemplate twoMongoTemplate;

    /**
     * 新增
     */
    @ResponseBody
    @GetMapping("/add")
    public void add(){

        User user = User.builder().id(UUID.randomUUID().toString()).userName("aa").password("111111").build();
        mongoTemplate.insert(user);
        User user2 = User.builder().id(UUID.randomUUID().toString()).userName("bb").password("2222").build();
        twoMongoTemplate.insert(user2);
    }

    @RequestMapping("/query")
    public String query() {
        Query query = Query.query(Criteria.where("userName").is("aa")/*.and("password").is("world1")*/);
        List<User> users = mongoTemplate.find(query, User.class);
        System.out.println(users.get(0));

        Query query2 = Query.query(Criteria.where("userName").is("bb")/*.and("password").is("world1")*/);
        List<User> users2 = twoMongoTemplate.find(query2, User.class);
        System.out.println(users2.get(0));
        return users2.size() + "";
    }
}