/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Student
 * Date Created : 2024-11-25
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-11-25       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.entity;

/**
 * @program: com.example.template.entity
 * @description: xxx
 * @author: w15021
 * @create: 2024-11-25
 **/

import lombok.Data;

/**
 * (Student)实体类
 *
 * @author 全栈学习笔记
 * @since 2020-04-14 11:39:10
 */
@Data
public class Student  {
    private static final long serialVersionUID = -91969758749726312L;
    /**
     * 唯一标识id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
}
