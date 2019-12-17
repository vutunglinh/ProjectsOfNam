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
public class Project_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter N: ");
        int n = 0;
        do {            
            try {
                n = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("N must be a number!");
                System.out.println("Please enter N: ");
            }
        } while (true);
        System.out.println(String.format("Sum of 1..%d is: %d", n, (n * (n + 1) / 2)));
    }
}
