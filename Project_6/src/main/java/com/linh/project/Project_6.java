/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linh.project;

import java.util.concurrent.Callable;

/**
 *
 * @author PC
 */
public class Project_6 {
    private static int n = 0;
    private static int m = 0;
    private static int matrix[][] = null;
    private static int digits[] = null;
    private static int size = 0;
    
    public static void main(String[] args) {
      
        loopcheck(()->{
            try {
                n = Integer.parseInt(System.console().readLine());
                return true;
            } catch (Exception e) {
            }
            return false;
        }, "Invalid 1st dimension", "Enter the 1st dimension");
        loopcheck(()->{
            try {
                m = Integer.parseInt(System.console().readLine());
                return true;
            } catch (Exception e) {
            }
            return false;
        }, "Invalid 2st dimension", "Enter the 2st dimension");
        matrix = new int[n][m];
        digits = new int[m];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                final int x = i;
                final int y = j;
                loopcheck(()->{
                    try {
                        matrix[x][y] = Integer.parseInt(System.console().readLine());
                        size = Math.max(size, getMaxDigit(matrix[x][y]));
                        return true;
                    } catch (Exception e) {
                    }
                    return false;
                }, String.format("Invalid value for element [%d, %d]", i, j), String.format("Enter value for element [%d, %d]: ", i, j));
            }
        }
        
        int sizeLine = Math.max("Input:".length(), (size + 2) * m + 1);
        int anchor = sizeLine + 10;
        int sizeLine2 = "Output:".length() + 3 * m + 1;
        System.out.println("Input:"+String.format("%"+anchor+"%s", "Output:"));
        for (int i = 0; i < n; i++) {
            String line = "";
            for (int j = 0; j < m; j++) {
                line += j == 0? " ["+String.format("%"+size+"d", matrix[i][j]) :
                        j == m -1? ", "+String.format("%"+size+"d", matrix[i][j]) +"]" 
                        : ", "+String.format("%"+size+"d", matrix[i][j]);
                String line2 = j == 0? " ["+String.format("%"+size+"d", matrix[i][j] % 2) :
                        j == m -1? ", "+String.format("%"+size+"d", matrix[i][j] % 2) +"]" 
                        : ", "+String.format("%"+size+"d", matrix[i][j] % 2);
                line += String.format("%"+(anchor+sizeLine)+"%s", line2);
            }
            System.out.println(line);
        }
        
        
        
//        System.out.println(String.format("%"+anchor+"%s", "Output:"));
//        for (int i = 0; i < n; i++) {
//            String line = "";
//            for (int j = 0; j < m; j++) {
//                line += j == 0? " ["+String.format("%"+size+"d", matrix[i][j] % 2) :
//                        j == m -1? ", "+String.format("%"+size+"d", matrix[i][j] % 2) +"]" 
//                        : ", "+String.format("%"+size+"d", matrix[i][j] % 2);
//            }
//            System.out.println(String.format("%"+(anchor+sizeLine)+"%s", line));
//        }
        
    }
    
    public static void loopcheck(Callable<Boolean> docheck, String error, String enterInput) {
        System.out.println(enterInput);
        do {            
            try {
                if (docheck != null)
                    if (!docheck.call()) {
                        System.out.println(error);
                        System.out.println(enterInput);
                        continue;
                    }
                
                break;
            } catch (Exception e) {
            }
        } while (true);
    }
    
    public static int getMaxDigit(int i) {
        long number = i;
        long digit = 10;
        int digits = 1;
        while ((number = number / digit) > 0) {
           digits++;
        }
        return digits;
    }
}
