/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : NotHelloWorld
 * Date Created : 2022-11-04
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-11-04       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.chapter10_2.code10_3;
import javax.swing.*;
import java.awt.*;
/**
 * @program: com.example.template.chapter10_2.code10_3
 * @description: xxx
 * @author: w15021
 * @create: 2022-11-04
 **/
public class NotHelloWorld
         {
         public static void main (String[] args)
        {
         EventQueue.invokeLater(() ->
                 {
         JFrame frame = new NotHelloWorldFrame();
         frame.setTitle("NotHelloWorld");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
         });
         }
        }


/**
 25 * A frame that contains a message panel
 */
  class NotHelloWorldFrame extends JFrame
  {
  public NotHelloWorldFrame()
        {
        add(new NotHel1oWorldComponent());
        //在框架中填入一个或多个组件时， 如果你只想使用它们的首选大小， 可以调用 pack 方法
            //而不是 setSize 方法
        pack();
        }}


/**
  * A component that displays a message.
 */
  class NotHel1oWorldComponent extends JComponent{
  public static final int MESSAGE_X = 75;
  public static final int MESSACE_Y = 100;

  private static final int DEFAULT_WIDTH = 300;
 private static final int DEFAULT_HEIGHT = 200;

  public void paintComponent(Graphics g) {
      g.drawString("Not a Hello, World program", MESSAGE_X, MESSACE_Y);
  }

  //组件要告诉用户它应该有多大。覆盖 getPreferredSize 方法， 返回一个有首选宽度
  //和高度的 Dimension 类对象
 public Dimension getPreferredSize() {
      return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
  }
}