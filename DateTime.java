package com.vedamic.testcaseactivity.calendar;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by yogesh on 11/24/16.
 */
public class DateTime {

    private static final String TAG = "==> DateTime";

    /**
     * Get current date and time.
     *
     * eg.of patttern yyyy-MM-dd HH:mm:ss
     *
     * @return Date according to the provided pattern.
     */
    public static String current(String pattern){
        DateFormat dateFormat = new SimpleDateFormat(pattern, Locale.US);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String current(){
        return current("yyyy-MM-dd");
    }

    /**
     * Gets one day after the submitted date.
     * <br>
     * The date must be in yyyy-mm-dd hh:mm:ss format.
     * <br>
     * <b>Note: Not a complete function</b><br>
     * This method doesn't actually yield tomorrows date but rather
     * adds 1 to the current date. This method fails in case of last day
     * of the month and last day of the year.
     *
     * @param dateTime
     *      the date in yyyy-mm-dd hh:mm:ss format
     * @return
     *      the date after the provided date
     */
    public static String oneDayAfter(String dateTime){
        try{

            //first get the date only
            String date = dateTime.split("\\s+")[0];

            //now get the date parameters
            String dateParams[] = date.split("-");

            //now increment the date by 1
            int day = Integer.parseInt(dateParams[2]);

            return date = dateParams[0]+"-"+dateParams[1]+"-"+(day + 1);

        }catch (ArrayIndexOutOfBoundsException e){
            Log.e(TAG, "oneDayAfter: "+e.getMessage());
        }catch (NumberFormatException e){
            Log.e(TAG, "oneDayAfter: "+e.getMessage());
        }
        return dateTime;
    }

    /**
     * Formats the appropriate year month and day into proper date string.
     *
     * @param year
     * @param month
     * @param day
     * @return Formatted date string.
     */
    public static String formatAppropriate(int year, int month, int day){
        String mthStr = String.valueOf(month);
        if(month < 10 && mthStr.length() < 2){
            mthStr = "0"+month;
        }

        String dayStr = String.valueOf(day);
        if(month < 10 && dayStr.length() < 2){
            dayStr = "0"+day;
        }

        return year+"-"+mthStr+"-"+dayStr;
    }

    public static String currentNp(){
        Calendar calendar = Calendar.getInstance();
        try {
            DateConverter converter = new DateConverter();
            DateConverter.Date date = converter.adToBs(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
            return date.toString();
        }catch (DateConverter.UnsupportedDateException e){
            Log.e(TAG, "currentNp: "+e.getMessage());
            e.printStackTrace();
        }
        return current();
    }

}
