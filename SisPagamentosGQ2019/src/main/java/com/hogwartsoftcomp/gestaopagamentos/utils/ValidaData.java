package com.hogwartsoftcomp.gestaopagamentos.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Felipe
 */
public class ValidaData {

    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static ValidaData instancia;
    
     private ValidaData() {
    }

    public static ValidaData getInstance() {
        if (instancia == null) {
            instancia = new ValidaData();
        }
        return instancia;
    }
    public boolean validaData(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean validaData(Date date) {
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

    public Date converteData(String data) throws ParseException {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.parse(data);
    }
    public String converteData(Date data) throws ParseException {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.format(data);
    }
}
