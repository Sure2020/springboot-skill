/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : UserRecord
 * Date Created : 2022-08-17
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-08-17       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.javatpoint.model;

/**
 * @program: com.javatpoint.model
 * @description: xxx
 * @author: w15021
 * @create: 2022-08-17
 **/
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class UserRecord
{
    @Id
    private int id;
    private String name;
    private String email;
    //default conatructor
    public UserRecord()
    {
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
}