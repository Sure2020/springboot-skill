/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ButtonFrame
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

package com.example.template.chapter11_1.code11_1;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @program: com.example.template.chapter11_1.code11_1
 * @description: xxx
 * @author: w15021
 * @create: 2022-11-04
 **/
public class ButtonFrameTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new ButtonFrame();
            frame.setTitle("ButtonFrameTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame. setVisible(true);
        });
    }
}
class ButtonFrame extends JFrame
        {
         private JPanel buttonPanel;
         private static final int DEFAULT_WIDTH = 300;
         private static final int DEFAULTJEICHT = 200;

         public ButtonFrame()

            {


                setSize(DEFAULT_WIDTH, DEFAULTJEICHT);
// create buttons
                JButton yellowButton = new JButton("Yellow");
                JButton blueButton = new JButton("Blue");
                JButton redButton = new JButton("Red");
                buttonPanel = new JPanel();
// add buttons to panel
                buttonPanel.add(yellowButton);
                buttonPanel.add(blueButton);
                buttonPanel.add(redButton);
// add panel to frame
                add(buttonPanel);
// create button actions
                ColorAction yellowAction = new ColorAction(Color.YELLOW);
                ColorAction blueAction = new ColorAction(Color.BLUE);
                ColorAction redAction = new ColorAction(Color.RED);
// associate actions with buttons
                yellowButton.addActionListener(yellowAction);
                blueButton.addActionListener(blueAction);
                redButton.addActionListener(redAction);
            }


/**
 * An action listener that sets the panel ' s background color.
 */
     private class ColorAction implements ActionListener
     {
         private Color backgroundColor;
         public ColorAction(Color c)
         {
             backgroundColor = c;
         }
         public void actionPerformed(ActionEvent event)
         {
             buttonPanel .setBackground(backgroundColor);
         }
     }
}
