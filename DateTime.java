
import android.util.Log;

import com.vedamic.chhimekbank.library.utils.Logger;

import org.apache.http.conn.UnsupportedSchemeException;

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
     * The date must be in yyyy-mm-dd hh:mm:ss or yyyy-mm-dd format.
     * <br>
     *
     * @param dateTime
     *      the date in yyyy-mm-dd hh:mm:ss or yyyy-mm-dd format
     * @return
     *      the date after the provided date
     */
    public static String getNextDay(String dateTime, boolean isGregorian) throws UnsupportedDateException {
        try{

            //first get the date only
            String date = dateTime.split("\\s+")[0];
            //now get the date parameters
            String dateParams[] = date.split("-");
            int year = Integer.parseInt(dateParams[0]);
            int month = Integer.parseInt(dateParams[1]);
            int day = Integer.parseInt(dateParams[2]);
            //check the edge cases
            if(isGregorian){
                int[] engData;
                //check if the year is the leap year
                if(DateConverter.isLeapYear(year)){
                    engData = DateData.englishLeapYear;
                }else{
                    engData = DateData.englishYear;
                }
                if(day == engData[month]){
                    day = 1;
                    if(month == 12){
                        year += 1;
                        month = 1;
                    }else{
                        month += 1;
                    }
                }else{
                    day += 1;
                }
            }else{
                if(year < DateData.getMinYear() || year > DateData.getMaxYear()){
                    throw new UnsupportedDateException("Nepali year is less than "+DateData.getMinYear()+" or more than "+DateData.getMaxYear());
                }
                int[] nepData = DateData.BS_YEARS_ARRAY[DateData.getMinYear() - year];
                if(day == nepData[month]){
                    day = 1;
                    if(month == 12){
                        year += 1;
                        month = 1;
                    }else{
                        month += 1;
                    }
                }else{
                    day += 1;
                }
            }
            return formatAppropriate(year,month,day);

        }catch (ArrayIndexOutOfBoundsException e){
            Logger.e(TAG, "getNextDay: "+e.getMessage());
        }catch (NumberFormatException e){
            Logger.e(TAG, "getNextDay: "+e.getMessage());
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
        }catch (UnsupportedDateException e){
            Logger.e(TAG, "currentNp: "+e.getMessage());
            e.printStackTrace();
        }
        return current();
    }

}
