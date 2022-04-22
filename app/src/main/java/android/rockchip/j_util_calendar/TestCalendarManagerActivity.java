package android.rockchip.j_util_calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestCalendarManagerActivity extends AppCompatActivity {
    private CalendarManager calendarManager;
    private String textTimes = "2022-02-30 07:35:53";
    private String[] updateTimes = {
            "2022-03-05 20:00:00",
            "2022-03-13 20:00:00",
            "2022-03-17 20:00:00",
            "2022-03-26 20:00:00",
            "2022-03-27 20:00:00",
            "2022-03-30 20:00:00",
    };

//    private String[] updateTimes ={
//            "2022- 20:e00:00",
//            "2022- 20:00:00",
//            "2022- 20:00:00",
//            "2022- 20:de00:00",
//            "2022- 20e:00:00",
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_calendar_manager);

        Date dateTest = DateUtils.fomatDate(textTimes);
        Calendar calendarTest = Calendar.getInstance();
        calendarTest.setTime(dateTest);

//        test(calendarTest);
        test2(updateTimes);

    }

    /**
     * 此方法測試
     * @param updateTimes
     */
    private void test2(String[] updateTimes) {
        calendarManager = new CalendarManager(Calendar.getInstance(), Calendar.SUNDAY, Calendar.SATURDAY);

        for (String updateTime : updateTimes) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(calendarManager.fomatDate(updateTime));
            calendarManager.setCalendar(updateTime);

            Date getFirstDayOfWeek = calendarManager.getFirstDayOfWeek();
            String getFirstDayOfWeekText = calendarManager.getFirstDayOfWeek(CalendarManager.yyyy_MM_dd);

            Date getLastDayOfWeek = calendarManager.getLastDayOfWeek();
            String getLastDayOfWeekText = calendarManager.getLastDayOfWeek(CalendarManager.yyyy_MM_dd);

            int weekOfYear = calendarManager.getWeekOfYear();

            String weekRangeText = calendarManager.getWeekRangeText(CalendarManager.yyyy_MM_dd);
            Log.v("hank", "測試 getFirstDayOfWeek:" + getFirstDayOfWeek + ", getFirstDayOfWeekText:" + getFirstDayOfWeekText + "getLastDayOfWeek:" + getLastDayOfWeek + ", getLastDayOfWeekText:" + getLastDayOfWeekText + ", weekOfYear:" + weekOfYear);
            Log.v("hank", "測試 weekRangeText:" + weekRangeText);
            Log.v("hank", "測試-----------------------------------------------------------------------------");
        }
        ;
    }

    private void test(Calendar calendarTest) {
        calendarManager = new CalendarManager(calendarTest, Calendar.SUNDAY, Calendar.SATURDAY);
        calendarManager.setCalendar(Calendar.getInstance());//設定新的日期
        calendarManager.setTargetFirstDayOfWeek(Calendar.MONDAY);//更改dayOfWeek的Target


        Date getFirstDayOfWeek = calendarManager.getFirstDayOfWeek();
        String getFirstDayOfWeekText = calendarManager.getFirstDayOfWeek(CalendarManager.yyyy_MM_dd);

        Date getLastDayOfWeek = calendarManager.getLastDayOfWeek();
        String getLastDayOfWeekText = calendarManager.getLastDayOfWeek(CalendarManager.yyyy_MM_dd);
        Log.v("hank", "測試 getFirstDayOfWeek:" + getFirstDayOfWeek.getTime() + ", getFirstDayOfWeekText:" + getFirstDayOfWeekText + "/n getLastDayOfWeek:" + getLastDayOfWeek + ", getLastDayOfWeekText:" + getLastDayOfWeekText);
    }
}