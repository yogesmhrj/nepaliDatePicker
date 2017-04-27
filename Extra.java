
import android.util.Log;

/**
 * Created by yogesh on 04 Apr, 2017.
 */
public class Extra {

    private static final String TAG = "==> Extra";

    public static String getNepaliCorresponding(int number){
        if(number < 0 || number > 10){
            return number+"";
        }
        switch (number){
            case 0:
            default:
                return "०";
            case 1:
                return "१";
            case 2:
                return "२";
            case 3:
                return "३";
            case 4:
                return "४";
            case 5:
                return "५";
            case 6:
                return "६";
            case 7:
                return "७";
            case 8:
                return "८";
            case 9:
                return "९";
        }
    }

    /**
     * Function to convert roman numeral into devanagari literal
     * i.e. 2011 into "२०११"
     *
     * @param romanNumerical
     * @return converted devanagari string.
     */
    public static String convertRomanIntoDevanagari(double romanNumerical){
        String romanNumber = String.valueOf(romanNumerical);
        try {
            return convertRomanIntoDevanagari(romanNumber);
        }catch (Exception e){
            Log.e(TAG, "convertRomanIntoDevanagari: "+e.getMessage());
            e.printStackTrace();
        }
        return romanNumber;
    }

    /**
     * Function to convert roman numeral into devanagari literal
     * i.e. 2011 into "२०११"
     *
     * @param romanNumber
     * @return converted devanagari string.
     */
    public static String convertRomanIntoDevanagari(String romanNumber){

        return romanNumber.replace("1","१")
                .replace("2","२")
                .replace("3","३")
                .replace("4","४")
                .replace("5","५")
                .replace("6","६")
                .replace("7","७")
                .replace("8","८")
                .replace("9","९")
                .replace("0","०");
    }

}
