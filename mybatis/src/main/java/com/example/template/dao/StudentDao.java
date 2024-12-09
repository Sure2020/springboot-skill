/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : StudentDao
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

package com.example.template.dao;

/**
 * @program: com.example.template.dao
 * @description: xxx
 * @author: w15021
 * @create: 2024-11-25
 **/

import com.example.template.entity.PartOfStudent;
import com.example.template.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author 全栈学习笔记
 * @since 2020-04-14 11:39:18
 */
@Mapper
//@Repository
public interface StudentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Integer id);
    @Select("select count(*) from student")
    Integer count();

    @Select("select id,age from student where id = #{id}")
    PartOfStudent queryPartOfStudent(Integer id);

    //注解方式
    @Select("select * from student where id = #{id}")
    Student queryByIdAnnotation(Integer id);

    //这里不加@Param("ids")注解的话，实测默认会传入名为list的参数名，而不是ids的参数名
    List<Student> batch(@Param("ids") List<Integer> ids);

    List<Student> batch_with_any(@Param("ids") List<Integer> ids);

    //测了也不行 ANY语法，但是数据库后台可以：select * from student where id =ANY(ARRAY[1,2]);
    //知道原因了，ARRAY[#{ids}]::varchar[] 语法是 PostgreSQL 专用的，mysqsl不行
    @Select("SELECT * FROM student WHERE id = ANY(ARRAY[#{ids}]::varchar[])")
    List<Student> getStudentsByIds(@Param("ids") List<Integer> ids);


    @Select("select * from student where age = #{age}")
    List<Student> queryByAge(@Param("age") Integer age);

    @Select("select * from student")
    List<Student> page();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param student 实例对象
     * @return 对象列表
     */
    List<Student> page(Student student);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

