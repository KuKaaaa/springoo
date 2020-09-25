package pl.kupczyk.springoo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final DateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd");

    public static Date createDate(String dateString){
        Date date = null;

        if (dateString == null){
            date = new Date();
        }
        else{
            try {
                date = dateFormatter.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return date;
    }
}
