/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : StudentServiceImpl
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

import com.example.template.dao.StudentDao;
import com.example.template.entity.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author 全栈学习笔记
 * @since 2020-04-14 11:39:19
 */
@Service//("studentervice")  该注解加到实现类上而不是接口上，因为spring需要实例化bean,而接口无法被实例化
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Integer id) {
        return this.studentDao.queryById(id);
    }

    @Override
    public Student queryByIdAnno(Integer id) {
        return this.studentDao.queryByIdAnnotation(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Student> queryAllByLimit(int offset, int limit) {
        return this.studentDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Student> batch(List<Integer> ids) {
        System.out.println("#############" + ids.toArray());
        return this.studentDao.batch(ids);
    }

    @Override
    public List<Student> queryByAge(Integer age) {
        return studentDao.queryByAge(age);
    }
    @Override
    public List<Student> page(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Student> studentList = studentDao.page();
        PageInfo pageInfo = new PageInfo(studentList);
        System.out.println("pages: " + pageInfo.getPages());
        System.out.println("total: " + pageInfo.getTotal());
        return studentList;
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student update(Student student) {
        this.studentDao.update(student);
        return this.queryById(student.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.studentDao.deleteById(id) > 0;
    }
}
