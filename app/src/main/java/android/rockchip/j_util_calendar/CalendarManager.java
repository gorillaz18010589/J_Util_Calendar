package android.rockchip.j_util_calendar;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 建構式,輸入Calendar格式,取得時間資訊功能,週的第一天,週的最後一天,這是一年的哪一週,週的rangeText
 */
public class CalendarManager {
    private Calendar mCalendar;
    private String TAG = "hank";
    private String className = getClass().getSimpleName() + " ->";
    public final static String yyyy_MM_dd = "yyyy-MM-dd";

    /**
     * 設定一週的第一天
     */
    private int mTargetFirstDayOfWeek;
    /**
     * 設定一周的最後一天
     */
    private int mTargetLastDayOfWeek;


    public CalendarManager(Calendar calendar, int mTargetFirstDayOfWeek, int mTargetLastDayOfWeek) {
        this.mCalendar = calendar;
        this.mTargetFirstDayOfWeek = mTargetFirstDayOfWeek;
        this.mTargetLastDayOfWeek = mTargetLastDayOfWeek;
    }

    public Calendar getCalendar() {
        return mCalendar;
    }

    public int get(int calendarField) {
        return mCalendar.get(calendarField);
    }

    /**
     * 取得今年的第幾週
     *
     * @return
     */
    public int getWeekOfYear() {
        Log.v(TAG, className + "getWeekOfYear:" + mCalendar.get(Calendar.WEEK_OF_YEAR));
        return mCalendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 取得週的第一天Date
     *
     * @return exSat Apr 23 11:34:28 GMT+08:00
     */
    public Date getFirstDayOfWeek() {
        Calendar calendar = mCalendar;
        calendar.set(Calendar.DAY_OF_WEEK, mTargetFirstDayOfWeek);
        Log.v(TAG, className + "getFirstDayOfWeek:" + calendar.getTime());
        return calendar.getTime();
    }

    /**
     * 依據時間格式,取得週的第一天String
     *
     * @param fmt ex yyyyMMdd
     * @return ex:2022-04-18
     */
    public String getFirstDayOfWeek(String fmt) {
        Calendar calendar = mCalendar;
        calendar.set(Calendar.DAY_OF_WEEK, mTargetFirstDayOfWeek);
        return fomatDate(calendar.getTime(), fmt);
    }

    /**
     * 取得週的最後一天Date
     *
     * @return exSat Apr 23 11:34:28 GMT+08:00
     */
    public Date getLastDayOfWeek() {
        Calendar calendar = mCalendar;
        calendar.set(Calendar.DAY_OF_WEEK, mTargetLastDayOfWeek);
        Log.v(TAG, className + "getLastDayOfWeek:" + calendar.getTime());
        return calendar.getTime();
    }

    /**
     * 依據時間格式,取得週的第一天String
     *
     * @param fmt ex yyyyMMdd
     * @return ex:2022-04-18
     */
    public String getLastDayOfWeek(String fmt) {
        Calendar calendar = mCalendar;
        calendar.set(Calendar.DAY_OF_WEEK, mTargetLastDayOfWeek);
        return fomatDate(calendar.getTime(), fmt);
    }

    public String getWeekRangeText(String fmt) {
        StringBuilder sb = new StringBuilder();
        sb.append(getFirstDayOfWeek(fmt)).append(" ~ ").append(getLastDayOfWeek(fmt));
        return sb.toString();
    }


    /**
     * @param mCalendar
     */
    public void setCalendar(Calendar mCalendar) {
        this.mCalendar = mCalendar;
    }

    /**
     * 輸入時間戳String,設定Calendar
     *
     * @param timestamp ex.2022-03-05 20:00:00
     */
    public void setCalendar(String timestamp) {
        try {
            Calendar calendar = mCalendar;
            calendar.setTime(fomatDate(timestamp));
            setCalendar(calendar);
        } catch (Exception e) {
            Log.v(TAG, className + "setCalendar(String timestamp) error:" + e.toString());
        }
    }


    public int getTargetFirstDayOfWeek() {
        return mTargetFirstDayOfWeek;
    }

    public void setTargetFirstDayOfWeek(int targetFirstDayOfWeek) {
        this.mTargetFirstDayOfWeek = targetFirstDayOfWeek;
    }

    public int getTargetLastDayOfWeek() {
        return mTargetLastDayOfWeek;
    }

    public void setTargetLastDayOfWeek(int targetLastDayOfWeek) {
        this.mTargetLastDayOfWeek = targetLastDayOfWeek;
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public Date fomatDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (date == null || "".equals(date) || "null".equals(date))
                return null;

            return fmt.parse(date);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }


    /**
     * 格式化日期
     *
     * @return
     */
    public Date fomatDate(String date, String sdfmt) {
        try {
            if (date == null || "".equals(date) || "null".equals(date))
                return null;

            return new SimpleDateFormat(sdfmt).parse(date);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }


    /**
     * 格式化日期
     *
     * @return
     */
    public String fomatDate(Date date, String sdfmt) {

        try {
            if (date == null)
                return null;

            return new SimpleDateFormat(sdfmt).format(date);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }
}
