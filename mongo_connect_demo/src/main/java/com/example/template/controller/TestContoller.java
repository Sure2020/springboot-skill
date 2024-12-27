/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestContoller
 * Date Created : 2024-11-29
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-11-29       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.controller;

/**
 * @program: com.example.template
 * @description: xxx
 * @author: w15021
 * @create: 2024-11-29
 **/

import com.example.template.entity.Passenger;
import com.example.template.entity.Table1;
import com.example.template.repository.PassengerRepository;
import com.example.template.repository.Table1Repository;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestContoller {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    PassengerRepository passengerRepository;



    @RequestMapping("/insert")
    public String insert() {
        Passenger passenger = new Passenger();
        passenger.setName("hello");
        passenger.setPassword("world1");
        passenger = mongoTemplate.insert(passenger);
        if (passenger != null) {
            return "success";
        } else {
            return "false";
        }
    }

    @RequestMapping("/query")
    public String query() {
        Query query = Query.query(Criteria.where("name").is("hello")/*.and("password").is("world1")*/);
        List<Passenger> passengers = mongoTemplate.find(query, Passenger.class);
        return passengers.size() + "";
    }

    @RequestMapping("/query2")
    public String query2() {
        Query query = Query.query(Criteria.where("name").is("hello").and("password").is("world1"));
        List<Passenger> passengers = mongoTemplate.find(query, Passenger.class);
        return passengers.size() + "";
    }

    @RequestMapping("/query/repo/all")
    public String queryRepo() {
        List<Passenger> passengers = passengerRepository.findAll();
        System.out.println(passengers.get(0));
        return "" + passengers.size();
    }

    @RequestMapping("/query/repo/one/{name}")
    public String queryRepoOne(@PathVariable("name") String name) {
        List<Passenger> passengers = passengerRepository.findByName(name);
        System.out.println(passengers.get(0));
        return "" + passengers.size();
    }

    @RequestMapping("/query/repo/count/{name}")
    public Integer queryRepoCount(@PathVariable("name") String name) {
        return passengerRepository.countByName(name);
    }

    @RequestMapping("/query/repo/count")
    public Long count() {
        return passengerRepository.count();
    }


    @RequestMapping("/update")
    public String update() {
        Query query = Query.query(Criteria.where("password").is("world1"));
        Update update = new Update();
        update.set("name", "world2");
        update.set("password", "world2");
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Passenger.class);
        return "success";
    }

    @RequestMapping("/remove")
    public String remove() {
        Query query = Query.query(Criteria.where("password").is("world1"));
        DeleteResult remove = mongoTemplate.remove(query, Passenger.class);
        return "success";
    }

    @GetMapping("/table1/1")
    public String table1_1(){
        //Table1 table1 = mongoTemplate.findById("a", Table1.class);
        List<Table1> table1List = mongoTemplate.findAll(Table1.class);
        System.out.println(table1List.size());
        System.out.println(table1List.get(0));
        System.out.println(table1List.get(0).toString());
        System.out.println("testing");
        return "testing";
    }

    @GetMapping("/table1/2")
    public String table1_2(){
        Table1 table1 = mongoTemplate.findById("676e5826760116692abd0060", Table1.class);
        System.out.println(table1.toString());
        System.out.println("testing");
        return "testing";
    }
    @Autowired
    Table1Repository table1Repository;
    @GetMapping("/table1/3")
    public String table1_3(){
//        Table1 table1 = mongoTemplate.findById("676e5826760116692abd0060", Table1.class);
        Table1 table1 = table1Repository.findByName("b");
        System.out.println(table1.toString());
        System.out.println("testing");
        return "testing";
    }


}