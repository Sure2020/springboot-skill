/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : SizedFraineTest
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

package com.example.template.chapter10_2.code10_2;
import java.awt.*;
import javax.swing.*;
/**
 * @program: com.example.template.chapter10_2.code10_2
 * @description: xxx
 * @author: w15021
 * @create: 2022-11-03
 **/
public class SizedFraineTest
{
        public static void main(String[] args)
        {
         EventQueue.invokeLater(() ->
        {
         JFrame frame = new SizedFrame() ;
        frame.setTitle("SizedFrame") ;
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
         frame.setVisible(true);
         });
        }
}

class SizedFrame extends JFrame {
public SizedFrame()
        {
        //get screen dimensions
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenHeight=screenSize.height;
        int screenWidth=screenSize.width;
// set frame width, height and let platform pick screen location
        setSize(screenWidth/2,screenHeight/2);
        setLocationByPlatform(true);
// set frame icon
        Image img=new ImageIcon("icon.gif").getImage();
        setIconImage(img);
        }
        }