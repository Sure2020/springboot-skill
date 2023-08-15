/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Testmember
 * Date Created : 2023-08-14
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-08-14       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.test.main;

import lombok.Data;

/**
 * @program: com.example.test.main
 * @description: xxx
 * @author: w15021
 * @create: 2023-08-14
 **/
@Data
public class Testmember {
    private String id;
    private String id2;
    /*public Testmember(){
        id2 = this.id;
    }*/

    public void setId(String id) {
        this.id = id;
        this.id2 = id;
    }
}