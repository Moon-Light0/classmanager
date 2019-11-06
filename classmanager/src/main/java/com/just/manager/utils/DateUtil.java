package com.just.manager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String date2String(String pattern, Date date){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static Date string2Date(String pattern, String str) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(str);
    }
}
