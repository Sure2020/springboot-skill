/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MathOperationAddition
 * Date Created : 2023-01-04
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-01-04       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.lambda.testmain;

/**
 * @program: com.example.lambda.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2023-01-04
 **/
public class MathOperationAddition implements Java8Tester.MathOperation {
    @Override
    public int operation(int a, int b) {
        return a + b;
    }
}