package com.emall.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @ClassName DateUtils
 * @Description 日期工具类
 * @Author weibin
 * @Date 2018/11/23 16:19
 * @Version 1.0
 **/
public class DateUtils {

    /**
     * 日期格式，精确到年份
     */
    public static final String DF_YYYY = "yyyy";
    /**
     * 日期格式，精确到月份
     */
    public static final String DF_YYYY_MM = "yyyy-MM";
    /**
     * 日期格式，精确到天数
     */
    public static final String DF_YYYY_MM_DD = "yyyy-MM-dd";
    /**
     * 日期格式，精确到秒
     */
    public static final String DF_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期格式,精确到分钟
     */
    public static final String DF_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    /**
     * 日期格式,精确到小时
     */
    public static final String DF_YYYY_MM_DD_HH = "yyyy-MM-dd HH";
    /**
     * 日期格式,精确到分钟
     */
    public static final String DF_YYYYMMDDHHMM = "yyyyMMddHHmm";
    /**
     * 日期格式,精确到秒
     */
    public static final String DF_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * @Description 私有构造方法
     * @Para[][]
     * @Author weibin
     * @D2018/12/17211:531:44
     * @Return
     **/
    private DateUtils() {
    }

    /**
     * @Description 获取当前时间，返回毫秒值，高并发量会存在性能问题，后续待优化
     * @Param []
     * @Author weibin
     * @Date 2018/11/23 16:19
     * @Return long
     **/
    public static long getNowTime() {
        return System.currentTimeMillis();
    }

    /**
     * 获取日期类的实例
     * 如果传入参数为空，则取当前系统时间
     *
     * @param date 日期对象
     * @return
     */
    private static final Calendar getCalendarInstance(Date date) {
        Calendar cl = Calendar.getInstance();
        if (null != date) {
            cl.setTime(date);
        }
        return cl;
    }

    /**
     * 获得指定日期之后，指定天数的日期
     * 如果日期为空，则获取当前日期之后，指定天数的日期
     *
     * @return
     * @throws Exception
     */
    public static final Date getNextDate(Date nowDate, int days) throws Exception {
        if (days <= 0) {
            throw new Exception(StringUtils.concat("天数【", days, "】不可以小于等于0"));
        }
        Calendar cl = getCalendarInstance(nowDate);
        cl.set(Calendar.DAY_OF_MONTH, cl.get(Calendar.DAY_OF_MONTH) + days);
        return cl.getTime();
    }

    /**
     * 获得指定日期之前，指定天数的日期
     * 如果日期为空，则获取当前日期之前，指定天数的日期
     *
     * @return
     * @throws Exception
     */
    public static final Date getPrevDate(Date nowDate, int days) throws Exception {
        if (days <= 0) {
            throw new Exception(StringUtils.concat("天数【", days, "】不可以小于等于0"));
        }
        Calendar cl = getCalendarInstance(nowDate);
        cl.set(Calendar.DAY_OF_MONTH, cl.get(Calendar.DAY_OF_MONTH) - days);
        return cl.getTime();
    }

    /**
     * 将时间字符串转换为日期
     *
     * @param dateStr 时间字符串
     * @param fromat  日期格式化
     * @return 日期
     * @throws Exception
     */
    public static final Date strToDate(String dateStr, String fromat) throws Exception {
        if (StringUtils.isNotNull(dateStr)) {
            if (StringUtils.isNull(fromat)) {
                throw new Exception("日期格式化参数不可以为空");
            }
            SimpleDateFormat sdf = new SimpleDateFormat(fromat, Locale.CHINA);
            Date time = sdf.parse(dateStr);
            sdf = null;  //销毁对象
            return time;
        } else {
            throw new Exception("日期参数不可以为空");
        }
    }

    /**
     * 按照参数format的格式，日期转字符串
     *
     * @param date   日期
     * @param format 日期格式化
     * @return 日期格式化后的字符串，例如：2018-07-12
     * @throws Exception
     */
    public static String dateToStr(Date date, String format) throws Exception {
        if (null != date && StringUtils.isNotNull(format)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
            return sdf.format(date);
        } else {
            throw new Exception("参数不可以为空");
        }
    }

    /**
     * 通过指定日期获取其年份，如果日期为空值则获取当前系统时间的年份
     *
     * @param date 日期
     * @return 年
     */
    public static final int getYear(Date date) {
        Calendar cal = getCalendarInstance(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取指定日期的月份，如果日期为空值则获取当前系统时间的月份
     *
     * @param date 日期
     * @return 月
     */
    public static final int getMonth(Date date) {
        Calendar cal = getCalendarInstance(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取指定日期所在月份的具体的天数，如果日期为空值则获取当前系统时间月份当天的天数
     *
     * @param date 日期
     * @return 日期所在月份具体的某一天
     */
    public static final int getDay(Date date) {
        Calendar cal = getCalendarInstance(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定日期所在月份的总天数，如果日期为空则取当前系统时间所在月份的总天数
     *
     * @param date 日期
     * @return 日期对应月份的总天数
     */
    public static final int getDaysOfMonth(Date date) {
        Calendar cal = getCalendarInstance(date);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定日期的小时数，如果日期为空值则获取当前系统时间的小时数
     *
     * @param date
     * @return
     */
    public static final int getHour(Date date) {
        Calendar cal = getCalendarInstance(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取指定日期所在分钟数，如果日期为空值则获取当前系统时间的分钟数
     *
     * @param date
     * @return
     */
    public static final int getMinute(Date date) {
        Calendar cal = getCalendarInstance(date);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * 获取指定日期所在月份的第一天的日期
     *
     * @param date 日期
     * @return 当月的第一天的日期
     */
    public static final Date getFirstDayOfMonth(Date date) {
        Calendar cal = getCalendarInstance(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取指定日期所在月份的最后一天
     *
     * @param date 日期
     * @return 当月最后一天的日期
     */
    public static final Date getLastDayOfMonthDate(Date date) {
        Calendar cal = getCalendarInstance(date);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获取指定日期，下个月的第一天，时间为空则取当前系统时间
     *
     * @param date 日期
     * @return 下个月第一天的日期
     */
    public static final Date getFirstDayOfNextMonth(Date date) {
        Calendar cal = getCalendarInstance(date);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取指定日期，上个月的第一天的日期，时间为空则取当前系统时间
     *
     * @param date 日期
     * @return 上个月第一天的日期
     */
    public static final Date getFirstDayOfPrevMonth(Date date) {
        Calendar cal = getCalendarInstance(date);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取指定日期，本月的最后一天，如果日期为空，则取系统时间对应的月份最后一天
     *
     * @param date 日期
     * @return 当月最后一天的日期
     */
    public static final int getLastDayOfMonth(Date date) {
        Calendar cal = getCalendarInstance(date);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 通过生日获取年龄
     *
     * @param birthday
     * @return
     */
    public static final int getAge(Date birthday) {
        Calendar nowTime = getCalendarInstance(null);
        Calendar birthdayTime = getCalendarInstance(birthday);
        return nowTime.get(Calendar.YEAR) - birthdayTime.get(Calendar.YEAR);
    }
}