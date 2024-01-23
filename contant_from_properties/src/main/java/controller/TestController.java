/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
 * Date Created : 2020-03-12
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-12       w15021     xxx
 * --------------------------------------------------------------------
 */

package controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: com.example.lishuiduijie_test.controller
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-12
 **/

@RestController
public class TestController {

    //经过尝试，用以下这种方式从配置文件中取常量值取不到
    /*public static final String KEY;
    public static final String API;
    static {
        KEY = ConstantProperties.getChengyunKeyPrivate();
        API = Constant.CHENGYUNAPIPARKINGS;
    }*/

    @GetMapping("/test/atValue")
    public String atValue(){

        System.out.println("a");
        System.out.println("");
        System.out.println("testValue");
        System.out.println("");
        System.out.println("");
        System.out.println("new TestAtValue().testAtValue()");
        return "yes";
    }
}