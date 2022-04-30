/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author TungNT
 */
public class Utils {
    public static String convertRoleID(int roleID) {
        String convertRoleID = null;
        switch(roleID) {
            case 1:
                convertRoleID = "AD";
                break;
            case 2:
                convertRoleID = "US";
                break;
        }
        return convertRoleID;
    }
    
    public static int convertRoleID(String roleID) {
        int convertRoleID = 0;
        switch(roleID) {
            case "AD":
                convertRoleID = 1;
                break;
            case "US":
                convertRoleID = 2;
                break;
        }
        return convertRoleID;
    }
    

    public static String convertDate(String date) {
        String convertDate = null;
        String tmp[] = date.split("/");
        String day = tmp[0];
        String month = tmp[1];
        String year = tmp[2];
        convertDate = year + "-" + month + "-" + day;
        return convertDate;
    }
    
    public static String convertPrice(double price) {
        String convertPrice = null;
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        convertPrice = en.format(price);
        return convertPrice;
    }
    
    public static String getCurrentDate(){
        String date = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        date = df.format(currentDate);
        return date;
    }
    
    public static String createOrderID(){
        String id = null;
        id = UUID.randomUUID().toString();
        return id;
    }

    
}
