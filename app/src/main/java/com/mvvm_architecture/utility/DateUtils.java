package com.mvvm_architecture.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
    public static String parseDateTime(String date, String inputPattern, String outputPattern){
        String datetime = null;
        try {
            datetime = new SimpleDateFormat(outputPattern).format(new SimpleDateFormat(inputPattern).parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return datetime;
    }
}
