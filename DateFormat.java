
/**
 * Created by yogesh on 04 Apr, 2017.
 */
public class DateFormat {

    /**
     * Formats the appropriate year month and day into proper date string.
     * i.e. 2015-1-1 into (2015-01-01)
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

    /**
     * Formats the appropriate year, month and day into proper nepali date literal string
     *  i.e. 2015-1-1 into "बि. सं. 2015 साल, बैशाख महिना 1 गते "
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String formatToLiteralNp(int year, int month, int day){
        String mthStr = String.valueOf(month);
        if(month < 10 && mthStr.length() < 2){
            mthStr = "0"+month;
        }

        String dayStr = String.valueOf(day);
        if(month < 10 && dayStr.length() < 2){
            dayStr = "0"+day;
        }

        return "बि. सं. "+Extra.convertRomanIntoDevanagari(year)+" साल, "
                + DateData.getNepaliMonthLtr(month)+" महिना "+
                Extra.convertRomanIntoDevanagari(dayStr)+" गते ";
    }

}
