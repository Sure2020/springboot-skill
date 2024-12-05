/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMain
 * Date Created : 2024-12-04
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-12-04       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.lambda.testmain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: com.example.lambda.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-04
 **/
public class TestMain {
    public static void main(String[] args) {
        System.out.println("testing");
        List<User> userList = new ArrayList<>();
        User user1 = new User("a","i",30);
        User user2 = new User("b","o",20);
        userList.add(user1);
        userList.add(user2);
        /*userList.stream().forEach(user -> {
            user.setName("c");
            System.out.println(user.getName());
        });*/

        //测试.collect
        Map<String,String> testMap = userList.stream().collect(Collectors.toMap(User::getName,User::getSex));
        System.out.println(testMap);
    }
}