/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DrawTest
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

package com.example.template.chapter10_5.code10_4;
import java.awt.*;
import java. awt.geom. *;
import javax.swing.*;
/**
 * @program: com.example.template.chapter10_5.code10_4
 * @description: xxx
 * @author: w15021
 * @create: 2022-11-04
 **/
public class DrawTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
JFrame frame = new DrawFrame();
            frame.setTitle("DrawTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame. setVisible(true);
        });
    }
}


/**
 * A frame that contains a panel with drawings
 */
 class DrawFrame extends JFrame
 {
 public DrawFrame()
 {
 add(new DrawComponent()) ;
 pack() ;
 }
 }



/**
 38 * A component that displays rectangles and ellipses.
 39 */
class DrawComponent extends JComponent
{
private static final int DEFAULT_WIDTH = 400;
private static final int DEFAULT_HEIGHT = 400;
public void paintComponent(Graphics g)
        {
        Graphics2D g2 = (Graphics2D) g;
// draw a rectangle
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;
        Rectangle2D rect = new Rectangle2D.Double(leftX , topY, width , height) ;
        g2 .draw(rect) ;

        // draw the enclosed ellipse

        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2 .draw(ellipse) ;

        // draw a diagonal line

        g2 .draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

        // draw a circle with the same center

        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY() ;
        double radius = 150;

            Ellipse2D circle = new Ellipse2D.Double() ;
        circle. setFrameFromCenter(centerX , centerY , centerX + radius, centerY + radius);
        g2 .draw(circle);
        }

public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
        }
