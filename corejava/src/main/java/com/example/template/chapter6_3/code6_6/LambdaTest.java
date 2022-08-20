/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LambdaTest
 * Date Created : 2022-08-20
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-08-20       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.chapter6_3.code6_6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

/**
 * @program: com.example.template.chapter6_3.code6_6
 * @description: xxx
 * @author: w15021
 * @create: 2022-08-20
 **/
/**
 9 * This program demonstrates the use of lambda expressions.
 10 * ©version 1.0 2015-05-12
 * ©author Cay Horstmann
 12 V
 */
 public class LambdaTest{
     public static void main(String[] args){
         String[] planets = new String[] { "Mercury" , "Venus", "Earth" , "Mars" ,
         "Jupiter" , "Saturn", "Uranus", "Neptune" };
         System.out.println(Arrays.toString (planets));
         System.out. println("Sorted in dictionary order:") ;
         Arrays.sort(planets) ;
         System.out.println (Arrays.toString(planets));
         System.out . println ("Sorted by length:");
         Arrays.sort (planets, (first , second) -> first.length()- second.length()) ;
         System.out. println(Arrays.toString(planets)) ;
         /*Timer t = new Timer(1000, event ->
            System.out.println ("The time is " + new Date())) ;
         t.start();*/
         // keep program running until user selects "0k"
         /*Timer t = new Timer(1000, event ->
                 System.out.println("The time is " + new Date()));*/

         JOptionPane.showMessageDialog (null , "Quit program?");
         System.exit (0);
 }}