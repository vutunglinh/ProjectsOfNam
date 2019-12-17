/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linh.project;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Project_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input String: ");
        String input = scanner.nextLine();
        String output = "";
    
        for(int i = input.length() - 1; i > -1 ; i--) 
            output += ""+input.charAt(i);
        System.out.println("Output String: "+output);
    }
}
