
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linh.project;

import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author PC
 */
public class Project_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input String: ");
        String input = scanner.nextLine();
        TreeMap<String, Integer> orders = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i)))
            if (orders.containsKey(input.charAt(i)+"")) {
                orders.put(input.charAt(i)+"", new Integer(orders.get(input.charAt(i)+"") + 1));
            } else orders.put(input.charAt(i)+"", new Integer(1));
        }
        for (String character : orders.keySet()) {
            System.out.print(character+": "+orders.get(character)+" ");
        }
    }
}
