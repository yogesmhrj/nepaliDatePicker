package com.vedamic.testcaseactivity.calendar;

import static com.vedamic.testcaseactivity.calendar.NpDateData.englishLeapYear;
import static com.vedamic.testcaseactivity.calendar.NpDateData.englishYear;

/**
 *
 * Class to convert the Date between AD and BS.
 * <br>
 * Check the Date ranges before implementation.
 * <br>
 * <ul>
 *     <li>Currently the supported dates are from 2000 to 2089 BS</li>
 *     <li>Currently the supported dates are from 1944 to 2033 AD</li>
 * </ul>
 *
 * Created by yogesh on 5/26/16.
 */
public class DateConverter {

    private String debugInfo = "";

    /**
     * Calculates wheather english year is leap year or not
     *
     * @param year
     * @return
     */
    public boolean isLeapYear(int year){

        if (year % 100 == 0)
        {
            return (year % 400 == 0);
        } else {
            return (year % 4 == 0);
        }
    }

    private boolean isInRangeEnglish(int year, int month, int day){

        if(year < 1944 ||  year >2033){
            return false;
        }

        if(month < 1 || month >12){
            return false;
        }

        if(day < 1 || day >31){
            return false;
        }

        return true;
    }

    private boolean isInRangeNepali(int year, int month, int day){

        if(year < 2000 || year > 2089){
            return false;
        }

        if(month<1 || month >12) {
            return false;
        }

        if(day<1 || day >32){
            return false;
        }

        return true;
    }

    /**
     * Convert the date from AD to BS.
     * <br><br>
     * Currently the supported dates are from 1944 to 2033
     *
     * @param currentYear
     * @param currentMonth
     * @param currentDay
     * @return
     */
    public Date adToBs(int currentYear,int currentMonth,int currentDay) throws UnsupportedDateException{

        //the start of english date
        final int defaultEnglishYear = 1944;
        final int defaultEnglishMonth = 0;
        final int defaultEnglishDay	  = 0;

        //equivalent english date
        final int defaultNepaliYear = 2000;
        final int defaultNepaliMonth = 9;
        final int defaultNepaliDay = 16;

        final int defaultDayOfWeek = 6;

        if (!this.isInRangeEnglish(currentYear, currentMonth, currentDay)){
            throw new UnsupportedDateException("Date range not supported : Currently the supported dates are from 1944 to 2033");
        } else {

            int totalEnglishDays = 0;

            // count total days from the default date year to the (current year - 1)
            for(int i=0; i < (currentYear - defaultEnglishYear); i++){
                //total days for month calculation...(english)
                if(this.isLeapYear(defaultEnglishYear + i)){
                    //year is leap year
                    for(int j = 0; j < 12; j++){
                        totalEnglishDays += englishLeapYear[j];
                    }
                }
                else{
                    for(int j=0; j<12; j++){
                        totalEnglishDays += englishYear[j];
                    }
                }
            }

            //System.out.println(totalEnglishDays);
            // count total no. of days for the current years before the ongoing month
            for(int i = 0; i < (currentMonth - 1); i++){
                if(this.isLeapYear(currentYear)){
                    totalEnglishDays += englishLeapYear[i];
                }
                else{
                    totalEnglishDays += englishYear[i];
                }
            }

            //System.out.println(totalEnglishDays);
            // finally get the total past days for the current month
            totalEnglishDays += currentDay;

            int daysInMonth = 0;

            int calculatedNepaliDay = defaultNepaliDay;
            int calculatedNepaliMonth = defaultNepaliMonth;
            int calculatedNepaliYear = defaultNepaliYear;

            int dayOfWeek = defaultDayOfWeek;

            // count nepali date from array
            for(int yearIndex = 0; totalEnglishDays > 0; totalEnglishDays--){
                //calculate the days present the monthIndex for the yearIndex
                daysInMonth = NpDateData.BS_YEARS_ARRAY[yearIndex][calculatedNepaliMonth];
                //for each english day increment the nepali day as well
                calculatedNepaliDay++;
                dayOfWeek++;

                //check if days exceeded the days to be in the month
                if(calculatedNepaliDay > daysInMonth){
                    //exceeded, thus increment a month
                    calculatedNepaliMonth++;

                    //reset the day to 1
                    calculatedNepaliDay = 1;

                }

                //check if the day of the week exceeds 7
                if(dayOfWeek > 7) {
                    //exceeded, reset the value
                    dayOfWeek = 1;
                }

                //check if the month exceeds by 12
                if(calculatedNepaliMonth > 12){
                    //exceeded, increment the year and the reset the calculated month
                    calculatedNepaliYear++;
                    calculatedNepaliMonth = 1;
                    yearIndex++;
                }
            }

            return new Date(calculatedNepaliYear,calculatedNepaliMonth,calculatedNepaliDay,dayOfWeek, Date.DATE_BS);
        }
    }

    /**
     * Method to convert BS date into AD date
     * <br><br>
     * Currently the supported dates are from 2000 to 2089
     * @param currentYear
     * @param currentMonth
     * @param currentDay
     * @return
     */
    public Date bsToAd(int currentYear,int currentMonth,int currentDay) throws UnsupportedDateException {

        //get the nepali date for the start of the year
        final int defaultNepaliYear 	= 2000;
        final int defaultNepaliMonth 	= 1;
        final int defaultNepaliDay 		= 1;

        //equivalent english date
        final int defaultEnglishYear 	= 1943;
        final int defaultEnglishMonth 	= 4;
        final int defaultEnglishDay	  	= 13;

        final int defaultDayOfWeek 	= 3;

        int totalNepaliDays		=0;

        if(!this.isInRangeNepali(currentYear, currentMonth, currentDay)){
            throw new UnsupportedDateException("Date range not supported : Currently the supported dates are from 2000 to 2089");
        } else {
            //get total nepali days
            int i = 0;
            for(i=0;  i<(currentYear- defaultNepaliYear);  i++){
                for(int j=1;  j<=12;  j++){
                    totalNepaliDays +=  NpDateData.BS_YEARS_ARRAY[i][j];
                }
            }

            for(int j=1;  j < currentMonth;  j++){
                totalNepaliDays +=  NpDateData.BS_YEARS_ARRAY[i][j];
            }

            totalNepaliDays += currentDay;

            //start the calculation for the equivalent english (AD) date
            int calculatedEnglishDays 	=  defaultEnglishDay;
            int calculatedEnglishMonth 	=  defaultEnglishMonth;
            int calculatedEnglishYear 	=  defaultEnglishYear;

            int daysInMonth 	= 0;
            int dayOfWeek 		= defaultDayOfWeek;

            while(totalNepaliDays != 0){

                if( this.isLeapYear(calculatedEnglishYear))
                {
                    daysInMonth =  englishLeapYear[calculatedEnglishMonth - 1];
                }
                else
                {
                    daysInMonth =  englishYear[calculatedEnglishMonth - 1];
                }

                calculatedEnglishDays++;
                dayOfWeek++;

                if( calculatedEnglishDays >  daysInMonth){
                    calculatedEnglishMonth++;
                    calculatedEnglishDays = 1;
                }

                if(calculatedEnglishMonth > 12){
                    calculatedEnglishYear++;
                    calculatedEnglishMonth = 1;
                }

                if(dayOfWeek > 7){
                    dayOfWeek = 1;
                }

                totalNepaliDays--;
            }

            return new Date(calculatedEnglishYear,calculatedEnglishMonth,calculatedEnglishDays,dayOfWeek, Date.DATE_AD);
        }
    }

    public static class Date{

        public int YEAR = 0;
        public int MONTH = 0;
        public int DAY = 0;
        public int DAY_OF_WEEK	= 0;
        public String DAY_OF_WEEK_STR = "";
        public String MONTH_STR = "";
        public int FORMAT = 1;

        public static final int DATE_AD = 1;
        public static final int DATE_BS = 2;

        public Date(int year,int month, int day, int dayOfWeek,int format){
            this.YEAR = year;
            this.DAY = day;
            this.MONTH = month;
            this.DAY_OF_WEEK = dayOfWeek;
            this.FORMAT = format;

            if(this.FORMAT == DATE_AD){
                this.MONTH_STR =  NpDateData.getEnglishMonth(month);
            }

            if(this.FORMAT == DATE_AD){
                this.MONTH_STR =  NpDateData.getEnglishMonth(month);
            }

            this.DAY_OF_WEEK_STR =  NpDateData.getEnglishDayOfTheWeek(dayOfWeek);
        }

        public String getNepaliMonth(){return NpDateData.getNepaliMonth(this.MONTH);}

        public String getEnglishMonth(){
            return NpDateData.getEnglishMonth(this.MONTH);
        }

        public String getDayOfTheWeek(){
            return NpDateData.getEnglishDayOfTheWeek(this.DAY_OF_WEEK);
        }

        public String toString(){

            String monthStr = this.MONTH+"";
            if(this.MONTH < 10){
                monthStr = "0"+monthStr;
            }

            String dayStr = this.DAY+"";
            if(this.DAY < 10){
                dayStr = "0"+dayStr;
            }

            return this.YEAR+"-"+monthStr+"-"+dayStr;
        }
    }

    public static class UnsupportedDateException extends Exception {

        public UnsupportedDateException(String detailMessage) {
            super("UnsupportedDateException : "+detailMessage);
        }
    }


}

