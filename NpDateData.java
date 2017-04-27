
/**
 * Created by yogesh on 13 Mar, 2017.
 */
public class NpDateData {

    public static final int[] englishYear	= new int[]{
            31,28,31,30,31,30,31,31,30,31,30,31
    };

    public static final int[] englishLeapYear = new int[]{
            31,29,31,30,31,30,31,31,30,31,30,31
    };

    public static final int[][] BS_YEARS_ARRAY = new int[][]{
            {2000,30,32,31,32,31,30,30,30,29,30,29,31},
            {2001,31,31,32,31,31,31,30,29,30,29,30,30},
            {2002,31,31,32,32,31,30,30,29,30,29,30,30},
            {2003,31,32,31,32,31,30,30,30,29,29,30,31},
            {2004,30,32,31,32,31,30,30,30,29,30,29,31},
            {2005,31,31,32,31,31,31,30,29,30,29,30,30},
            {2006,31,31,32,32,31,30,30,29,30,29,30,30},
            {2007,31,32,31,32,31,30,30,30,29,29,30,31},
            {2008,31,31,31,32,31,31,29,30,30,29,29,31},
            {2009,31,31,32,31,31,31,30,29,30,29,30,30},
            {2010,31,31,32,32,31,30,30,29,30,29,30,30},
            {2011,31,32,31,32,31,30,30,30,29,29,30,31},
            {2012,31,31,31,32,31,31,29,30,30,29,30,30},
            {2013,31,31,32,31,31,31,30,29,30,29,30,30},
            {2014,31,31,32,32,31,30,30,29,30,29,30,30},
            {2015,31,32,31,32,31,30,30,30,29,29,30,31},
            {2016,31,31,31,32,31,31,29,30,30,29,30,30},
            {2017,31,31,32,31,31,31,30,29,30,29,30,30},
            {2018,31,32,31,32,31,30,30,29,30,29,30,30},
            {2019,31,32,31,32,31,30,30,30,29,30,29,31},
            {2020,31,31,31,32,31,31,30,29,30,29,30,30},
            {2021,31,31,32,31,31,31,30,29,30,29,30,30},
            {2022,31,32,31,32,31,30,30,30,29,29,30,30},
            {2023,31,32,31,32,31,30,30,30,29,30,29,31},
            {2024,31,31,31,32,31,31,30,29,30,29,30,30},
            {2025,31,31,32,31,31,31,30,29,30,29,30,30},
            {2026,31,32,31,32,31,30,30,30,29,29,30,31},
            {2027,30,32,31,32,31,30,30,30,29,30,29,31},
            {2028,31,31,32,31,31,31,30,29,30,29,30,30},
            {2029,31,31,32,31,32,30,30,29,30,29,30,30},
            {2030,31,32,31,32,31,30,30,30,29,29,30,31},
            {2031,30,32,31,32,31,30,30,30,29,30,29,31},
            {2032,31,31,32,31,31,31,30,29,30,29,30,30},
            {2033,31,31,32,32,31,30,30,29,30,29,30,30},
            {2034,31,32,31,32,31,30,30,30,29,29,30,31},
            {2035,30,32,31,32,31,31,29,30,30,29,29,31},
            {2036,31,31,32,31,31,31,30,29,30,29,30,30},
            {2037,31,31,32,32,31,30,30,29,30,29,30,30},
            {2038,31,32,31,32,31,30,30,30,29,29,30,31},
            {2039,31,31,31,32,31,31,29,30,30,29,30,30},
            {2040,31,31,32,31,31,31,30,29,30,29,30,30},
            {2041,31,31,32,32,31,30,30,29,30,29,30,30},
            {2042,31,32,31,32,31,30,30,30,29,29,30,31},
            {2043,31,31,31,32,31,31,29,30,30,29,30,30},
            {2044,31,31,32,31,31,31,30,29,30,29,30,30},
            {2045,31,32,31,32,31,30,30,29,30,29,30,30},
            {2046,31,32,31,32,31,30,30,30,29,29,30,31},
            {2047,31,31,31,32,31,31,30,29,30,29,30,30},
            {2048,31,31,32,31,31,31,30,29,30,29,30,30},
            {2049,31,32,31,32,31,30,30,30,29,29,30,30},
            {2050,31,32,31,32,31,30,30,30,29,30,29,31},
            {2051,31,31,31,32,31,31,30,29,30,29,30,30},
            {2052,31,31,32,31,31,31,30,29,30,29,30,30},
            {2053,31,32,31,32,31,30,30,30,29,29,30,30},
            {2054,31,32,31,32,31,30,30,30,29,30,29,31},
            {2055,31,31,32,31,31,31,30,29,30,29,30,30},
            {2056,31,31,32,31,32,30,30,29,30,29,30,30},
            {2057,31,32,31,32,31,30,30,30,29,29,30,31},
            {2058,30,32,31,32,31,30,30,30,29,30,29,31},
            {2059,31,31,32,31,31,31,30,29,30,29,30,30},
            {2060,31,31,32,32,31,30,30,29,30,29,30,30},
            {2061,31,32,31,32,31,30,30,30,29,29,30,31},
            {2062,30,32,31,32,31,31,29,30,29,30,29,31},
            {2063,31,31,32,31,31,31,30,29,30,29,30,30},
            {2064,31,31,32,32,31,30,30,29,30,29,30,30},
            {2065,31,32,31,32,31,30,30,30,29,29,30,31},
            {2066,31,31,31,32,31,31,29,30,30,29,29,31},
            {2067,31,31,32,31,31,31,30,29,30,29,30,30},
            {2068,31,31,32,32,31,30,30,29,30,29,30,30},
            {2069,31,32,31,32,31,30,30,30,29,29,30,31},
            {2070,31,31,31,32,31,31,29,30,30,29,30,30},
            {2071,31,31,32,31,31,31,30,29,30,29,30,30},
            {2072,31,32,31,32,31,30,30,29,30,29,30,30},
            {2073,31,32,31,32,31,30,30,30,29,29,30,31},
            {2074,31,31,31,32,31,31,30,29,30,29,30,30},
            {2075,31,31,32,31,31,31,30,29,30,29,30,30},
            {2076,31,32,31,32,31,30,30,30,29,29,30,30},
            {2077,31,32,31,32,31,30,30,30,29,30,29,31},
            {2078,31,31,31,32,31,31,30,29,30,29,30,30},
            {2079,31,31,32,31,31,31,30,29,30,29,30,30},
            {2080,31,32,31,32,31,30,30,30,29,29,30,30},
            {2081,31,31,32,32,31,30,30,30,29,30,30,30},
            {2082,30,32,31,32,31,30,30,30,29,30,30,30},
            {2083,31,31,32,31,31,30,30,30,29,30,30,30},
            {2084,31,31,32,31,31,30,30,30,29,30,30,30},
            {2085,31,32,31,32,30,31,30,30,29,30,30,30},
            {2086,30,32,31,32,31,30,30,30,29,30,30,30},
            {2087,31,31,32,31,31,31,30,30,29,30,30,30},
            {2088,30,31,32,32,30,31,30,30,29,30,30,30},
            {2089,30,32,31,32,31,30,30,30,29,30,30,30},
            {2090,30,32,31,32,31,30,30,30,29,30,30,30}};

    public static int getMinYear(){
        return BS_YEARS_ARRAY[0][0];
    }

    public static int getMaxYear(){
        return BS_YEARS_ARRAY[BS_YEARS_ARRAY.length - 1][0];
    }

    public static String getNepaliMonth(int month){

        switch(month){
            case 1:
                return "Baishak";
            case 2:
                return "Jestha";
            case 3:
                return "Ashad";
            case 4:
                return "Shrawn";
            case 5:
                return "Bhadra";
            case 6:
                return "Ashwin";
            case 7:
                return "kartik";
            case 8:
                return "Mangshir";
            case 9:
                return "Poush";
            case 10:
                return "Magh";
            case 11:
                return "Falgun";
            case 12:
                return "Chaitra";
            default:
                return "";
        }
    }

    public static String getNepaliMonthLtr(int month){

        switch(month){
            case 1:
                return "बैशाख ";
            case 2:
                return "जेठ ";
            case 3:
                return "आषाढ ";
            case 4:
                return "साउन ";
            case 5:
                return "भाद्र";
            case 6:
                return "आश्विन ";
            case 7:
                return "कार्तिक ";
            case 8:
                return "मंसीर";
            case 9:
                return "पौष ";
            case 10:
                return "माघ ";
            case 11:
                return "फाल्गुण";
            case 12:
                return "चैत्र ";
            default:
                return "";
        }
    }

    public static String getEnglishMonth(int month){

        switch(month){
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "";
        }
    }

    public static String getEnglishDayOfTheWeek(int day){

        switch(day){
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                return "";
        }
    }

    public static String getNepaliDayOfTheWeek(int day){
        switch(day){
            case 1:
                return "आइतबार ";
            case 2:
                return "सोमबार ";
            case 3:
                return "मंगलबार ";
            case 4:
                return "बुधबार ";
            case 5:
                return "बिहिबार ";
            case 6:
                return "शुक्रबार ";
            case 7:
                return "सनिबार ";
            default:
                return "";
        }
    }

}
