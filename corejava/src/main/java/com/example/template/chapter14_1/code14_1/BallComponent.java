/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : BallComponent
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

package com.example.template.chapter14_1.code14_1;
import java.awt.*;
import java.util.*;
import javax.swing.*;
/**
 * @program: com.example.template.chapter14_1.code14_1
 * @description: xxx
 * @author: w15021
 * @create: 2022-11-04
 **/
public class BallComponent extends JPanel
        {
private static final int DEFAULT_WIDTH = 450;
private static final int DEFAULT_HEIGHT = 350;

private java.util.List<Ball> balls = new ArrayList<>();

/**
 * Add a ball to the component.
 * Qparam b the ball to add
 */
 public void add(Ball b)
        {
        balls.add(b);
        }

public void paintComponent(Graphics g){
        super.paintComponent(g); // erase background
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls)
        {
        g2.fill(b.getShape());
        }
 }
        }