/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linh.project;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author PC
 */
public class Project_1 {
    public static void main(String[] args) {
        way_3(args);
    }
    
    public static void way_1(String[] args) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
    public static void way_2(String[] args) {
        for (int i = 0; i < 6; i++) {
            String line = StringUtils.repeat("*", 2 * i + 1);
            System.out.println(String.format("%"+(5-i + 2 * i + 1)+"s", line));
        }
    }
    
    public static void way_3(String[] args) {
        String result = "";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5 * 2 + 1; j++) {
                int center = 5;
                if (j < center - i || j > center + i)
                    result += " ";
                else result += "*";
            }
            result += "\n";
        }
        System.out.println(result);
    }
}
