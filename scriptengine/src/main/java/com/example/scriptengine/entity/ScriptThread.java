/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ScriptThread
 * Date Created : 2023-04-21
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-04-21       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.scriptengine.entity;

/**
 * @program: com.example.scriptengine.entity
 * @description: xxx
 * @author: w15021
 * @create: 2023-04-21
 **/
public abstract class ScriptThread extends Thread {
    //线程运行状态标记
    private boolean done = false;

    public boolean isDone() {
        return done;

    }

    @Override
    public void run() {
        execute();
        this.done = true;
    }

    public abstract void execute();

}


