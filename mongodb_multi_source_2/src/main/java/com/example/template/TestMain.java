/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMain
 * Date Created : 2024-12-30
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-12-30       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.example.template
 * @description: xxx
 * @author: w15021
 * @create: 2024-12-30
 **/
public class TestMain {
    public static void main(String[] args) {
        System.out.println("testing");
        List<String> testList = new ArrayList<>();
        testList.add("a");
        testList.add("b");
        testList.add("c");
        testList.stream().forEach(str -> {
            if(str.equals("b")){
                return ;
            }
            System.out.println(str);
        });
    }
}