/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : StudentService
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

package com.example.template.service;

/**
 * @program: com.example.template.service
 * @description: xxx
 * @author: w15021
 * @create: 2024-11-26
 **/

import com.example.template.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author 全栈学习笔记
 * @since 2020-04-14 11:39:19
 */
//@Service
public interface StudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Integer id);
    Student queryByIdAnno(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
