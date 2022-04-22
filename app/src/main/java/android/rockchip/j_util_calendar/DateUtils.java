package android.rockchip.j_util_calendar;

import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 */
public class DateUtils {
    public static String TAG = "DateUtils ->";
    /**
     * yyyy格式
     */
    public static final String sdfyyyy = "yyyy";
    /**
     * yyyy-MM-dd格式
     */
    public static final String sdfyyyy_MM_dd = "yyyy-MM-dd";


    /**
     * yyyy-MM-dd 00:00:00格式
     */
    public static final String sdfyyyyMMdd_00_00_00 = "yyyy-MM-dd 00:00:00";

    /**
     * yyyy-MM-dd 00:00:00格式
     */
    public static final String sdfyyyyMMdd_23_59_59 = "yyyy-MM-dd 23:59:59";


    /**
     * yyyy年MM月dd日格式
     */
    public static final String sdfyyyyCMMCddC = "yyyy年MM月dd日";
    /**
     * yyyyMMdd格式
     */
    public static final String sdfyyyyMMdd = "yyyyMMdd";
    /**
     * yyyy-MM-dd HH:mm:ss格式
     */
    public static final String sdfyyyy_MM_ddHHmmss = "yyyy-MM-dd HH:mm:ss";
    /**
     * yyyy-MM-dd HH:mm格式
     */
    public static final String sdfyyyy_MM_ddHHmm = "yyyy-MM-dd HH:mm";
    /**
     * yyyy年MM月dd日 HH:mm:ss格式
     */
    public static final String sdfyyyyCMMCddCHHmmss = "yyyy年MM月dd日 HH:mm:ss";
    /**
     * HH:mm:ss格式
     */
    public static final String sdfHHmmss = "HH:mm:ss";
    /**
     * yyyyMMddHHmmss格式
     */
    public static final String sdfyyyyMMddHHmmss = "yyyyMMddHHmmss";
    /**
     * yyyyMM格式
     */
    public static final String sdfyyyyMM = "yyyyMM";
    /**
     * yyyy-MM格式
     */
    public static final String sdfyyyy_MM = "yyyy-MM";
    /**
     * MMdd格式
     */
    public static final String sdfMMdd = "MMdd";
    /**
     * HHmm格式
     */
    public static final String sdfHHmm = "HHmm";

    public static final String sdfyyMMddSlash = "yyyy / MM / dd";

    public static final int START_TIME_TYPE = 0;
    public static final int END_TIME_TYPE = 1;

    /**
     * 獲取yyyyMMddHHmmss格式
     *
     * @return
     */
    public static String getSdfTimes() {
        return new SimpleDateFormat(sdfyyyyMMddHHmmss).format(new Date());
    }

    /**
     * 獲取YYYYMM格式
     *
     * @return
     */
    public static String getMonth() {
        return new SimpleDateFormat(sdfyyyy_MM).format(new Date());
    }


    /**
     * 獲取上一個月
     *
     * @return
     */
    public static String getLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        return dft.format(cal.getTime());
    }

    /**
     * 描述:獲取下一個月.
     *
     * @return
     */
    public static String getPreMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        return dft.format(cal.getTime());
    }

    /**
     * 獲取YYYY格式
     *
     * @return
     */
    public static String getYear() {
        return new SimpleDateFormat(sdfyyyy).format(new Date());
    }

    /**
     * 獲取YYYY-MM-DD格式
     *
     * @return
     */
    public static String getDay() {
        return new SimpleDateFormat(sdfyyyy_MM_dd).format(new Date());
    }

    /**
     * 獲取YYYYMMDD格式
     *
     * @return
     */
    public static String getDays() {
        return new SimpleDateFormat(sdfyyyyMMddHHmmss).format(new Date());
    }


    /**
     * 獲取YYYY-MM-DD HH:mm:ss格式
     *
     * @return
     */
    public static String getTime() {
        return new SimpleDateFormat(sdfyyyy_MM_ddHHmmss).format(new Date());
    }

    /**
     * @param s
     * @param e
     * @return boolean
     * @throws
     * @Title: compareDate
     * @Description: TODO(日期比較 ， 如果s > = e 返回true 否則返回false)
     * @author fh
     */
    public static boolean compareDate(String s, String e) {
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return false;
        }
        return fomatDate(s).getTime() >= fomatDate(e).getTime();
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static Date fomatDate(String date) {
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
    public static Date fomatDate(String date, String sdfmt) {
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
    public static String fomatDate(Date date, String sdfmt) {

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

    /**
     * 格式化日期
     *
     * @return
     */
    public static Date fomatDateToDate(Date date, String sdfmt) {
        return fomatDate(fomatDate(date, sdfmt), sdfmt);
    }

    /**
     * 校驗日期是否合法
     *
     * @return
     */
    public static boolean isValidDate(String s) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fmt.parse(s);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就說明格式不對
            return false;
        }
    }

    /**
     * @param startTime
     * @param endTime
     * @return
     */
    public static int getDiffYear(String startTime, String endTime) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {

            return (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);

        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就說明格式不對
            System.out.println(e);
            return 0;
        }
    }

    /**
     * <li>功能描述：時間相減得到天數
     *
     * @param beginDateStr
     * @param endDateStr
     * @return long
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;

        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println(e);
        }
        if (beginDate != null && endDate != null)
            day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        //System.out.println("相隔的天數="+day);

        return day;
    }

    /**
     * <li>功能描述：時間相減得到秒
     *
     * @param beginDateStr
     * @param endDateStr
     * @return long
     * @author Administrator
     */
    public static long getDaySubTime(String beginDateStr, String endDateStr) {
        long second = 0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;

        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println(e);
        }
        if (beginDate != null && endDate != null)
            second = (endDate.getTime() - beginDate.getTime()) / (1000);

        return second;
    }


    /**
     * 得到n天之後的日期
     *
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期減 如果不夠減會將月變動
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdfd.format(date);
    }

    /**
     * 得到n天之後的日期
     *
     * @param days
     * @return
     */
    public static String getAfterDayDate(int days) {
        int daysInt = days;

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期減 如果不夠減會將月變動
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdfd.format(date);
    }

    /**
     * 得到n天之後的日期
     *
     * @param days
     * @return
     */
    public static Date getAfterDay(int days) {
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, days); // 日期減 如果不夠減會將月變動
        return canlendar.getTime();
    }

    /**
     * 得到n天之後的日期
     *
     * @param days
     * @return
     */
    public static Date getAfterDay(int days, String sdfmt) {
        return fomatDate(fomatDate(getAfterDay(days), sdfmt), sdfmt);
    }

    /**
     * 獲取當前月的天數
     *
     * @return
     */
    public static int getDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getActualMaximum(Calendar.DATE);
    }

    /**
     * 根據指定時間得到n小時之後的時間
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getAfterHour(Date date, int n) {
        Calendar canlendar = Calendar.getInstance();
        canlendar.setTime(date);
        canlendar.add(Calendar.HOUR, n);
        return canlendar.getTime();
    }

    /**
     * 得到n天之後是周幾
     *
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期減 如果不夠減會將月變動
        Date date = canlendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        return sdf.format(date);
    }

    /**
     * 返回第一個引數加上第二個引數（天）之後的日期
     *
     * @param date
     * @param day
     * @return
     */
    public static Date getDateNext(Date date, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * 根據日期字串,傳入幾天,得到向後幾天日期
     *
     * @param date 日期
     * @param day  幾天
     * @return
     */
    public static Date getDateNext(String date, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(fomatDate(date));
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * 取得上月日期
     *
     * @param monthNum 月數
     * @return
     */
    public static String getLastMonth(int monthNum) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1 * monthNum);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        return dateFormat.format(c.getTime());
    }

    /**
     * 下月第一天
     *
     * @return
     */
    public static Date nextMonthFirstDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 上月第一天
     *
     * @return
     */
    public static Date lastMonthFirstDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 將日期中的時分秒清零
     *
     * @param date
     * @return
     */
    public static Date getDayStart(Date date) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        return cal1.getTime();
    }

    /**
     * 1970/01/01至今的秒數轉換成Date
     *
     * @param timeStamp
     * @return
     */
    public static Date getDateByTimeStamp(Long timeStamp) {
        return new Date(timeStamp * 1000);
    }

    /**
     * 1970/01/01至今的豪秒數轉換成Date
     *
     * @param timeStampMs
     * @return
     */
    public static Date getDateByTimeStampMs(Long timeStampMs) {
        return new Date(timeStampMs);
    }

    /**
     * 時間轉換成秒 1970/01/01至今的秒數（Date轉long），等於new Date().getTime()/1000
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static long getTimeStampByDate(Date date) {
        long stamp = 0L;
        Date date1 = date;
        Date date2 = null;
        try {
            date2 = (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).parse("1970/01/01 08:00:00");
            stamp = (date1.getTime() - date2.getTime()) / 1000L;
        } catch (Exception e) {
            stamp = 0L;
        }

        return stamp;
    }

    /**
     * 時間轉換成秒 1970/01/01至今的豪秒數（Date轉long）
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static long getTimeStampMsByDate(Date date) {
        long stamp = 0L;
        Date date1 = date;
        Date date2 = null;
        try {
            date2 = (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).parse("1970/01/01 08:00:00");
            stamp = (date1.getTime() - date2.getTime());
        } catch (Exception e) {
            stamp = 0L;
        }

        return stamp;
    }

    /**
     * 獲取當前時間之前或之後幾小時 hour
     *
     * @param hour
     * @return
     */
    public static Date getTimeByHour(int hour) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);

        //return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
        return calendar.getTime();
    }


    /**
     * 把毫秒转化成日期
     *
     * @param dateFormat(日期格式，例如：MM/ dd/yyyy HH:mm:ss)
     * @param millSec(毫秒数)
     * @return
     */
    public static String transferLongToDate(String dateFormat, Long millSec) {
        if (millSec < 1)
            return "00:00";

//参数一是格式，参数二是转换语言标准（Locale.ENGLISH，英文大写）
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        Date date = new Date(millSec);
        return sdf.format(date);
    }

    //常用转换
    public static String transferLongToDate(Long millSec) {
        if (millSec < 1) {
            return "00:00";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date date = new Date(millSec);
            return sdf.format(date);
        }
    }


    /**
     * 將dateString 轉成"yyyy-MM-dd HH:mm:ss";
     *
     * @param date
     * @return
     */
    public static Date fomatDateSdfyyyy_MM_ddHHmmss(String date) {
        DateFormat fmt = new SimpleDateFormat(sdfyyyy_MM_ddHHmmss);
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
     * 將dateString 轉成"yyyy-MM-dd-00:00:00;
     *
     * @param date
     * @return
     */
    public static Date fomatDateSdfyyyy_MM_dd_00_00_00(String date) {
        DateFormat fmt = new SimpleDateFormat(sdfyyyy_MM_ddHHmmss);
        try {
            if (date == null || "".equals(date) || "null".equals(date))
                return null;
            Date currentDate = fmt.parse(date);
            currentDate.setHours(00);
            currentDate.setMinutes(00);
            currentDate.setSeconds(00);
            return currentDate;
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }

    /**
     * 將dateString 轉成"yyyy-MM-dd-00:00:00;
     *
     * @param date
     * @return
     */
    public static Date fomatDateSdfyyyy_MM_dd_today_end_time(String date) {
        DateFormat fmt = new SimpleDateFormat(sdfyyyy_MM_ddHHmmss);
        try {
            if (date == null || "".equals(date) || "null".equals(date))
                return null;
            Date currentDate = fmt.parse(date);
            currentDate.setHours(23);
            currentDate.setMinutes(59);
            currentDate.setSeconds(59);
            return currentDate;
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }


    /**
     * 將dateString 轉成"yyyy-MM-dd HH:mm:ss";
     *
     * @param date
     * @return
     */
    public static Date fomatDates(String date, String fomat) {
        DateFormat fmt = new SimpleDateFormat(fomat);
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
     * @param dateTime   時間戳
     * @param dateFormat (日期格式，例如：MM/ dd/yyyy HH:mm:ss)
     * @return string Date
     */
    public static String dateTimeToDateText(String dateTime, String dateFormat) {
        return fomatDate(fomatDateSdfyyyy_MM_ddHHmmss(dateTime), dateFormat);
    }


    public static int get24HourByAmPm(int amPmType, int hour) {
        int newHour = hour;
        if (amPmType == 0) {
            //am
            if (newHour == 12)
                newHour = 0;
        } else {
            //pm
            if (newHour != 12) {
                newHour = newHour + 12;
            }
        }
        return newHour;
    }

    public static int getHourByAmPm(int amPmType, int hour) {
        int newHour = hour;
        if (amPmType == 0) {
            //am
            if (newHour == 0)
                newHour = 12;
        } else {
            //pm
            if (newHour != 12) {
                newHour = newHour - 12;
            }
        }
        return newHour;
    }

    /**
     * @return 回傳 yyyy-MM-dd 00:00:00
     */
    public static String getToDayStartTime() {
        String toDayStartTime = DateUtils.fomatDate(java.util.Calendar.getInstance().getTime(), DateUtils.sdfyyyy_MM_ddHHmmss);
        Date toDayFormDate = DateUtils.fomatDateSdfyyyy_MM_dd_00_00_00(toDayStartTime);
        String timeStart = DateUtils.fomatDate(toDayFormDate, DateUtils.sdfyyyy_MM_ddHHmmss);
        return timeStart;
    }

    /**
     * @return 回傳 yyy-MM-dd 23:59:59
     */
    public static String getToDayEndTime() {
        String toDayEndTime = DateUtils.fomatDate(java.util.Calendar.getInstance().getTime(), DateUtils.sdfyyyy_MM_ddHHmmss);
        Date toDayToDate = DateUtils.fomatDateSdfyyyy_MM_dd_today_end_time(toDayEndTime);
        String timeEnd = DateUtils.fomatDate(toDayToDate, DateUtils.sdfyyyy_MM_ddHHmmss);
        return timeEnd;
    }

    /**
     * @param date
     * @param type 0 : yyyy-MM-dd-00:00  / 1: yyyy-MM-dd-23:59:59
     * @return
     */
    public static String getyyyyMMddStartEndTimeByType(Date date, int type) {
        String currentDate = DateUtils.fomatDate(date, DateUtils.sdfyyyy_MM_ddHHmmss);
        String currentTime = "";
        if (type == START_TIME_TYPE) {
            Date toDayFormDate = DateUtils.fomatDateSdfyyyy_MM_dd_00_00_00(currentDate);
            currentTime = DateUtils.fomatDate(toDayFormDate, DateUtils.sdfyyyy_MM_ddHHmmss);
        } else {
            Date toDayToDate = DateUtils.fomatDateSdfyyyy_MM_dd_today_end_time(currentDate);
            currentTime = DateUtils.fomatDate(toDayToDate, DateUtils.sdfyyyy_MM_ddHHmmss);
        }
        return currentTime;
    }


    /**
     * 取得指定日期所在周的第一天

     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.SATURDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime ();
    }

    /**
     * 取得
     * @param time
     * @return
     */
    public static Date getWeekFirstDayByDate(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(time);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(java.util.Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(java.util.Calendar.SUNDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(java.util.Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(java.util.Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
//        System.out.println("所在周星期一的日期：" + sdf.format(cal.getTime()));
        return cal.getTime();
    }

    /**
     * 取得指定日期所在周的最後一天
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }




    /**
     * 獲取當月第一天
     * @param pattern 時間格式
     * @return
     */
    public static String getFirstDayOfMonth(String pattern){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,0);//當月的日期減去0天
        calendar.set(Calendar.DAY_OF_MONTH,1);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String fistDayOfMonth = format.format(calendar.getTime());
        return fistDayOfMonth;
    }

    /**
     * 獲取當月最後一天
     * @param pattern 時間格式
     * @return
     */
    public static String getLastDayOfMonth(String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH) //取得當月最後一天
        );
        String lastDayOfMonth = format.format(calendar.getTime());
        return lastDayOfMonth;
    }


    /**
     * 依據使用者給的日期,回傳這是今年的第幾週
     *
     * @param time String時間戳
     * @return 今年的第幾週
     */
    //获取周数
    public static String getWeekOfYearByDate(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);

        System.out.println();
        int i = calendar.get(Calendar.WEEK_OF_YEAR);
        return String.valueOf(i);
    }

}
