package com.cssrumi;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {

    private static Calendar cal = Calendar.getInstance();
    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public static void error(String message) {
        System.out.println(sdf.format(cal.getTime()) + " Error: " + message);
    }

    public static void log(String message) {
        System.out.println(sdf.format(cal.getTime()) + " : " + message);
    }
}
