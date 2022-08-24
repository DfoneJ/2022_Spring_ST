package Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static String getFormatDate(Date date) {
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        String day = String.format("%te", date);
        if (day.length() == 1)
            day = "0" + day;
        String month = String.format(Locale.US, "%tb", date);
        String year = getYearFormat.format(date);
        String week = String.format(Locale.US, "%ta", date);
        return week + " " + day + " " + month + " " + year;
    }

    public static String getFormatDateForCanlander(Date date) {
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        String day = String.format("%te", date);
        if (day.length() == 1)
            day = "0" + day;
        String month = String.format(Locale.US, "%tB", date);
        String year = getYearFormat.format(date);
        return day + " " + month + " " + year;
    }

    public static Date getSpecifyDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return new Date(calendar.getTimeInMillis());
    }
}
