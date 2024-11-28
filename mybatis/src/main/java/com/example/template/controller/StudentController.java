/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : StudentController
 * Date Created : 2024-11-26
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-11-26       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.controller;

/**
 * @program: com.example.template.controller
 * @description: xxx
 * @author: w15021
 * @create: 2024-11-26
 **/

import com.example.template.entity.Student;
import com.example.template.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * (Student)表控制层
 *
 * @author 全栈学习笔记
 * @since 2020-04-14 11:39:20
 */
@RestController
@RequestMapping("t")
public class StudentController {
    /**
     * 服务对象
     */
//    @Resource
    @Autowired
    private StudentService studentService2;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Student selectOne(Integer id) {
        return this.studentService2.queryById(id);
    }

    @GetMapping("selectOneAnno")
    public Student selectOneAnno(Integer id) {
        return this.studentService2.queryByIdAnno(id);
    }
    @GetMapping("batch")
    public List<Student> batch(@RequestParam("ids") List<Integer> ids) {
        System.out.println(ids.toArray());
        System.out.println(ids);
        return this.studentService2.batch(ids);
    }

    @GetMapping("age")
    public List<Student> queryByAge(@RequestParam("age") Integer age) {
        return this.studentService2.queryByAge(age);
    }
    @GetMapping("page")
    public List<Student> page(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        return this.studentService2.page(pageNum, pageSize);
    }
}
