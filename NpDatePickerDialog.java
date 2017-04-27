
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * Created by yogesh on 04 Apr, 2017.
 */
public class NpDatePickerDialog extends AlertDialog.Builder{

    private Context context;

    private static final String TAG = "==> NpDatePickerDialog";

    private NumberPicker yearPicker;
    private NumberPicker monthPicker;
    private NumberPicker dayPicker;

    private static int PICKED_YEAR = 2000;
    private static int PICKED_MONTH = 1;
    private static int PICKED_DAY = 1;

    private OnNpDateSetListener listener;

    public NpDatePickerDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        this.setTitle("नेपाली मिति छान्नुहोस् ");
    }

    public NpDatePickerDialog(@NonNull Context context, OnNpDateSetListener listener) {
        this(context);
        this.listener = listener;
    }

    public NpDatePickerDialog(@NonNull Context context, int pickedYear, int pickedMonth, int pickedDay, OnNpDateSetListener listener) {
        this(context);
        //set the proper picked year
        PICKED_YEAR = pickedYear > DateData.getMaxYear() ? DateData.getMaxYear() : pickedYear;
        PICKED_DAY = pickedYear < DateData.getMinYear() ? DateData.getMinYear() : pickedYear;
        //set the proper month
        PICKED_MONTH = pickedMonth > 12 ? 12 : pickedMonth;
        PICKED_MONTH = pickedMonth < 1 ? 1 : pickedMonth;
        //set the proper day
        PICKED_DAY = pickedDay > 32 ? 32 : pickedDay;
        PICKED_DAY = pickedDay < 1 ? 1 : pickedDay;

        this.listener = listener;
    }

    @Override
    public AlertDialog show() {
        this.setView(createView());
        this.setPositiveButton("Set", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if(listener != null){
                    listener.onNpDateSet(PICKED_YEAR, PICKED_MONTH, PICKED_DAY);
                }
            }
        });
        this.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return super.show();
    }

    /**
     * Creates the view for the dialog.
     * @return
     */
    private View createView(){
        LinearLayout.LayoutParams matchParentParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        //the parent layout
        LinearLayout layout = new LinearLayout(this.context);
        layout.setLayoutParams(matchParentParams);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setPadding(16,16,16,16);

        LinearLayout.LayoutParams wrapContentParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        //we need weight as 1 for the views
        wrapContentParams.weight = 1;
        wrapContentParams.gravity = Gravity.CENTER_HORIZONTAL;

        matchParentParams.weight = 1;

        //inner layouts
        LinearLayout yearLayout = new LinearLayout(this.context);
        yearLayout.setWeightSum(1);
        yearLayout.setLayoutParams(wrapContentParams);
        yearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView yearText = new TextView(this.context);
        yearText.setLayoutParams(wrapContentParams);
        yearText.setText("बि. सं. साल ");
        yearText.setGravity(View.TEXT_ALIGNMENT_CENTER);
        yearLayout.addView(yearText);

        this.yearPicker = new NumberPicker(this.context);
        this.yearPicker.setLayoutParams(matchParentParams);
        this.yearPicker.setMaxValue(2090);
        this.yearPicker.setMinValue(2000);
        this.yearPicker.setWrapSelectorWheel(false);
        this.yearPicker.setValue(PICKED_YEAR);
        Log.d(TAG, "createView: picked year "+PICKED_YEAR);
        this.yearPicker.setOnValueChangedListener(yearPickedListener);
        yearLayout.addView(this.yearPicker);

        layout.addView(yearLayout);

        LinearLayout monthLayout = new LinearLayout(this.context);
        monthLayout.setWeightSum(1);
        monthLayout.setLayoutParams(wrapContentParams);
        monthLayout.setOrientation(LinearLayout.VERTICAL);
        TextView monthText = new TextView(this.context);
        monthText.setLayoutParams(wrapContentParams);
        monthText.setText("महिना ");
        monthLayout.addView(monthText);
        //the number picker
        this.monthPicker = new NumberPicker(this.context);
        this.monthPicker.setLayoutParams(wrapContentParams);
        this.monthPicker.setMaxValue(12);
        this.monthPicker.setMinValue(1);
        this.yearPicker.setValue(PICKED_MONTH);
        this.monthPicker.setOnValueChangedListener(monthPickedListener);
        monthLayout.addView(this.monthPicker);

        layout.addView(monthLayout);

        LinearLayout daylayout = new LinearLayout(this.context);
        daylayout.setWeightSum(1);
        daylayout.setLayoutParams(wrapContentParams);
        daylayout.setOrientation(LinearLayout.VERTICAL);
        TextView dayText = new TextView(this.context);
        dayText.setLayoutParams(wrapContentParams);
        dayText.setText("गते ");
        daylayout.addView(dayText);
        //the number picker
        this.dayPicker = new NumberPicker(this.context);
        this.dayPicker.setLayoutParams(wrapContentParams);
        this.dayPicker.setMaxValue(32);
        this.dayPicker.setMinValue(1);
        this.yearPicker.setValue(PICKED_DAY);
        this.dayPicker.setOnValueChangedListener(dayPickedListener);
        daylayout.addView(this.dayPicker);

        layout.addView(daylayout);

        return layout;
    }

    private NumberPicker.OnValueChangeListener yearPickedListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            PICKED_YEAR = newVal;
            //need to update the days with the respective month and year
            fillDaysInPicker(PICKED_YEAR, PICKED_MONTH);
        }
    };

    private NumberPicker.OnValueChangeListener monthPickedListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            PICKED_MONTH = newVal;
            //need to update tht days the new month
            fillDaysInPicker(PICKED_YEAR, PICKED_MONTH);
        }
    };

    private NumberPicker.OnValueChangeListener dayPickedListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            PICKED_DAY = newVal;
        }
    };

    private void fillDaysInPicker(int year, int month){
        if(year < 2000){
            return;
        }
        try {
            this.dayPicker.setMaxValue(DateData.BS_YEARS_ARRAY[year - 2000][month]);
        }catch (ArrayIndexOutOfBoundsException e){
            Log.e(TAG, "fillDaysInPicker: "+e.getMessage());
            e.printStackTrace();
        }
    }


    public interface OnNpDateSetListener {
        /**
         * Gets called when a new nepali date has been selected.
         *
         * @param year The selected nepali year (2000 - 2090)
         * @param month The selected nepali month (1 - 12)
         * @param day The selected nepali day of the month (1 - 32);
         */
        void onNpDateSet(int year, int month, int day);
    }
}
