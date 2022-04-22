package android.rockchip.j_util_calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "hank";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String textTimes = "2022-03-27 07:35:53";
        Date textTime = DateUtils.fomatDate(textTimes);
        Calendar calendarTest = Calendar.getInstance();
        calendarTest.setTime(textTime);

        try {
            Log.v(TAG ,"區間: "  + getFirstAndLastOfWeek("2022-02-06 07:35:53"));
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            Log.v(TAG,"這周最後一天:" + getLastDayOfWeek("2022-03-31:35:53"));
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        //取得依據你所在的時區,日期,取得當前時間
        Calendar calendar = Calendar.getInstance();
        Log.v(TAG, "Calendar.getInstance() -> calendar:" + calendar.toString());

        //取得當週第一天,美國的話是星期日,法國星期一
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        Log.v(TAG, "firstDayOfWeek ->" + firstDayOfWeek);


        int dayOfWeek = calendarTest.get(Calendar.DAY_OF_WEEK);
        int weekOfYear = calendarTest.get(Calendar.WEEK_OF_YEAR);
        String weekOfFirstDay = String.valueOf(DateUtils.getWeekFirstDayByDate(DateUtils.fomatDate(textTimes)));
        String firstAndLastWeek ="";
        try {
            firstAndLastWeek =   "區間: "  + getFirstAndLastOfWeek(getLastDayOfWeek(textTimes));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        Log.v(TAG, "calendar.get(Calendar.WEEK_OF_YEAR) -> weekOfYear:" + weekOfYear +", dayOfWeek:" + dayOfWeek +", weekOfFirstDay:" + weekOfFirstDay +", firstAndLastWeek:" + firstAndLastWeek);

        Date date = calendar.getTime();
        Log.v(TAG, "calendar.getTime() -> date:" + date.toString());

    }

    public static String getFirstAndLastOfWeek(String dataStr) throws Exception {
        Calendar cal = Calendar.getInstance();

        cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dataStr));

        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -7;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        // 所在周开始日期
        String data1 = new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        // 所在周结束日期
        String data2 = new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
        return data1 + "-" + data2;

    }


    /**
     * 輸入日期,取的日~六一周的最後一天(星期六)
     *
     * @param day
     * @return 日~六一周的最後一天(星期六)
     * @throws Exception
     */
    public static String getLastDayOfWeek(String day) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(day));
        int currentDay = cal.get(Calendar.DAY_OF_WEEK);
        int leftDays = Calendar.SATURDAY - currentDay;
        cal.add(Calendar.DATE, leftDays);
        Log.v(TAG ,"currentDay:" + currentDay +", leftDays:" + leftDays);
        return sdf.format(cal.getTime());
    }


    public void toPage2(View view) {
        startActivity(new Intent(MainActivity.this, TestCalendarManagerActivity.class));
    }
}