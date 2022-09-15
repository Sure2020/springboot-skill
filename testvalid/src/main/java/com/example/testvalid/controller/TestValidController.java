/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestValidController
 * Date Created : 2022-09-15
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-09-15       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.testvalid.controller;

import com.example.testvalid.pojo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @program: com.example.testvalid.controller
 * @description: xxx
 * @author: w15021
 * @create: 2022-09-15
 **/

/**
 * @Validated 和 @Valid注解
 * @Validated 是 @Valid的封装，一般情况下用@Validated就够了，只有当需要嵌套验证时，需要在被嵌套的成员对象上用@Valid注解标注，因为@Validated注解无法用在成员变量上。
 * 参考链接：
 * 怎样用：https://www.jianshu.com/p/1dff31a1649d
 * 两者区别：https://blog.csdn.net/qq_27680317/article/details/79970590
 */
@RestController
//@Validated
public class TestValidController {
    @GetMapping("/valid/get")
    public String testvalid (@RequestParam
                                 @NotNull(message = "cat not be null")
                                 /*@Valid*/ @Validated     String id
                             /*BindingResult bindingResult*/) {
        /*if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage();
        }*/
        return id;
    }

    @PostMapping("/valid/post")
    public String validPost (@RequestBody /*@Valid*/ @Validated User user
                             /*BindingResult bindingResult*/) {
        /*if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return bindingResult.getFieldError().getDefaultMessage();
        }*/

        return user.getId();
    }
}