
package com.hogwartsoftcomp.gestaopagamentos.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Felipe
 */
public abstract class ValidaData {
    final static String DATE_FORMAT = "dd-MM-yyyy";
    
    public static boolean validaData(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
}
    
 public static boolean validaData(Date date) {
    
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            String data = df.format(date);
            df.setLenient(false);
            df.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
}
    public static Date converteData(String data) throws ParseException{
       DateFormat df = new SimpleDateFormat(DATE_FORMAT);
       return df.parse(data);
    }
}
