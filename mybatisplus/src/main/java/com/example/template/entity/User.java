package com.example.template.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("`user`")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
