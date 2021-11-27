/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ngomi
 */
public class Utility {
    public static  String CovertDateToString(Date myDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String strDate = formatter.format(myDate);  
        return strDate;
    }
}

