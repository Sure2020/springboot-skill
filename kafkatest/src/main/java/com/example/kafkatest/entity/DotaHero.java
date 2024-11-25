/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DotaHero
 * Date Created : 2024-11-18
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-11-18       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.kafkatest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.example.template.entity
 * @description: xxx
 * @author: w15021
 * @create: 2024-11-18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DotaHero {

    private String name;
    private String kind;
    private String sex;

    /**
     * 返回一个不同元素的数组
     * @return
     */
    public static List<DotaHero> bulidDiffObjectList(){
        List<DotaHero> list = new ArrayList<>();
        list.add(new DotaHero("影魔", "敏捷", "男"));
        list.add(new DotaHero("小黑", "敏捷", "女"));
        list.add(new DotaHero("马尔斯", "力量", "男"));

        return list;
    }
}