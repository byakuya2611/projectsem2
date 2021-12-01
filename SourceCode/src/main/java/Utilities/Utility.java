/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ngomi
 */
public class Utility {
    public static  String CovertDateTimeToString(Date myDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String strDate = formatter.format(myDate);  
        return strDate;
    }
    public static Date ConvertStringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    public static  String ConvertDateToString(Date myDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = formatter.format(myDate);  
        return strDate;
    }
    public static Time ConvertStringToTime(String timeString) {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
        Time time = null;
        try {
            time = new java.sql.Time(formatter.parse(timeString).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return time;
    }
    public static String ConvertTimeToString(Time myTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String strTime = formatter.format(myTime);
        return strTime;
    }
        
}

