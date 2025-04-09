/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMain
 * Date Created : 2025-01-08
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2025-01-08       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.test;

/**
 * @program: com.example.template.test
 * @description: xxx
 * @author: w15021
 * @create: 2025-01-08
 **/
import java.util.*;
import java.util.stream.Collectors;



public class TestMain {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "Alice"),
                new Person(2, "Bob"),
                new Person(1, "Charlie"),  // 重复的 id
                new Person(3, "David")
        );

        // 根据 id 去重，保留第一个出现的对象
        List<Person> distinctPeople = people.stream()
                .collect(Collectors.toMap(
                        Person::getId,  // 键：id
                        person -> person,  // 值：person 对象
                        (existing, replacement) -> existing  // 处理冲突：保留第一个出现的对象
                ))
                .values()
                .stream()
                .collect(Collectors.toList());

        distinctPeople.forEach(System.out::println);
        // #####################
        System.out.println(TestEnum.A.name());
        System.out.println(TestEnum.B.name());
        TestEnum e1 = TestEnum.A;
        TestEnum e2 = TestEnum.A;
        TestEnum e3 = TestEnum.B;
        System.out.println(e1.equals(e2));
        System.out.println(e1.equals(e3));

        System.out.println("#####");
        int a = 64;
        int b = 1056;
        double ratio = (double) a/b;
        System.out.println(ratio);

    }
}