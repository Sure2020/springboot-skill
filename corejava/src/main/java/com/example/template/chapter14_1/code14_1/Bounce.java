/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Bounce
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
import java.awt.event.*;
import javax.swing.*;
/**
 * @program: com.example.template.chapter14_1.code14_1
 * @description: xxx
 * @author: w15021
 * @create: 2022-11-04
 **/
public class Bounce
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
JFrame frame = new BounceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    });
    }
}


/**
 * The frame with ball component and buttons.
 */
class BounceFrame extends JFrame {
    private BallComponent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;

    /**
     * Constructs the frame with the component for showing the bouncing ball and
     * Start and Close buttons
     */
    public BounceFrame() {
        setTitle("Bounce");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }


    /**
     * Adds a button to a container.
     *
     * @param c        the container
     * @param title    the button title
     * @param listener the action listener for the button
     */
    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }


    /**
     * Adds a bouncing ball to the panel and makes it bounce 1,000 times .
     */
    public void addBall() {
        try {
            Ball ball = new Ball();
            comp.add(ball);
            for (int i = 1; i <= STEPS; i++) {
                ball.move(comp.getBounds());
                comp.paint(comp.getGraphics());
                Thread.sleep(DELAY);
            }
        }catch(InterruptedException e){}
    }
}




