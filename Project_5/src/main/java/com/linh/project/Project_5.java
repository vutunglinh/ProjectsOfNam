/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linh.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Project_5 {
    private static Date beginDate = null;
    private static Date endDate = null;
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Begin Date: ");
        final DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        dateFormat.setLenient(false);
        loopcheck(()->{
            try {
                final String beginDate_str = reader.readLine();
//                System.out.println(""+beginDate_str);
                beginDate = dateFormat.parse(beginDate_str);
                return true;
            } catch (Exception e) {
                System.out.println("The date is invalid");
                return false;
            }
        }, "The date is invalid", "Begin Date: ");
        System.out.println("End Date: ");
        loopcheck(()->{
            try {
                final String endDate_str = reader.readLine();
                endDate = dateFormat.parse(endDate_str);
                if (!endDate.after(beginDate)) {
                    System.out.println("The end date must be after the start date");
                    return false;
                }
                return true;
            } catch (Exception e) {
                System.out.println("The date is invalid");
                return false;
            }
        }, "The date is invalid", "End Date: ");
        Date nextDate = beginDate;
        System.out.println(""+nextDate.getDay());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nextDate);
        System.out.println("Calendat "+calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(""+nextDate.getDate());
        System.out.println(""+nextDate.getMonth());
        Date firstSaturday = nextDate(nextDate, 6 - nextDate.getDay());
        System.out.println("first "+firstSaturday+" "+(6 - nextDate.getDay()));
        ArrayList<Date> dates = new ArrayList<>();
        while (firstSaturday.before(endDate) || firstSaturday.equals(endDate)) {
            dates.add(firstSaturday);
            firstSaturday = nextDate(firstSaturday, 7);
        }
        System.out.println(String.format("There are %d Staturdays from %s to %s", dates.size(), dateFormat.format(beginDate), dateFormat.format(endDate)));
        for (Date date : dates) {
            System.out.println(String.format("    %s", dateFormat.format(date)));
        }
        try {
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(Project_5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void loopcheck(Callable<Boolean> doInput, String error, String enterInput) {
        do {
            try {
                if (doInput != null) {
                    if (!doInput.call()) {
                        System.out.print(enterInput);
                        continue;
                    }
                } 
                break;
            } catch (Exception e) {
                System.out.println(""+e.getMessage());
            }
            
        } while (true) ;
    }
    
    public static Date nextDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }
    
    public static Date nextDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }
}
