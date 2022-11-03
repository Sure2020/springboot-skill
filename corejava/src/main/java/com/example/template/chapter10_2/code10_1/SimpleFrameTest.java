/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : SimpleFrameTest
 * Date Created : 2022-11-03
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-11-03       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.chapter10_2.code10_1;
import java.awt.*;
import javax.swing.*;
/**
 * @program: com.example.template.chapter10_2.code10_1
 * @description: xxx
 * @author: w15021
 * @create: 2022-11-03
 **/
public class SimpleFrameTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            SimpleFrame frame = new SimpleFrame() ;
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
            frame.setVisible(true) ;
        });
    }
}

class SimpleFrame extends JFrame{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
    public SimpleFrame()
        {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        }
}
