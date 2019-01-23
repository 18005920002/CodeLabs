package com.labs.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 日历工具
 *
 * @author win10
 * @version v1.0 2019/1/11 11:14
 */
public class CalendarUtil {

    private static final String YEARMONTH_FORMAT = "yyyyMM";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 检查日期
     * @return
     */
    public static String checkMonth(String yearMonth) throws Exception{
        Calendar c = getCalendar(yearMonth);
        SimpleDateFormat format = new SimpleDateFormat(YEARMONTH_FORMAT);
        return format.format(c.getTime());
    }

    /**
     * 当前年月【yyyyMM】
     * @return
     */
    public static String currentMonth() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(YEARMONTH_FORMAT);
        return format.format(c.getTime());
    }

    /**
     * 上个月【yyyyMM】
     * @return
     */
    public static String previousMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH,-1);
        SimpleDateFormat format = new SimpleDateFormat(YEARMONTH_FORMAT);
        return format.format(c.getTime());
    }
    /**
     * 下个月【yyyyMM】
     * @return
     */
    public static String nextMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH,1);
        SimpleDateFormat format = new SimpleDateFormat(YEARMONTH_FORMAT);
        return format.format(c.getTime());
    }

    /**
     * 指定年月的上个月【yyyyMM】
     * @param yearMonth
     * @return
     * @throws Exception
     */
    public static String previousMonth(String yearMonth) throws Exception{
        Calendar c = getCalendar(yearMonth);
        SimpleDateFormat format = new SimpleDateFormat(YEARMONTH_FORMAT);
        c.add(Calendar.MONTH,-1);
        return format.format(c.getTime());
    }

    /**
     * 指定年月的下个月【yyyyMM】
     * @param yearMonth
     * @return
     * @throws Exception
     */
    public static String nextMonth(String yearMonth) throws Exception{
        Calendar c = getCalendar(yearMonth);
        SimpleDateFormat format = new SimpleDateFormat(YEARMONTH_FORMAT);
        c.add(Calendar.MONTH,1);
        return format.format(c.getTime());
    }

    /**
     * 某月第一天【yyyy-MM-dd】
     * @param yearMonth
     * @return
     * @throws Exception
     */
    public static String firstDayOfMonth(String yearMonth) throws Exception{
        Calendar c = getCalendar(yearMonth);
        c.set(Calendar.DATE,1);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        return format.format(c.getTime());
    }

    /**
     * 某月最后一天【yyyy-MM-dd】
     * @param yearMonth
     * @return
     * @throws Exception
     */
    public static String lastDayOfMonth(String yearMonth) throws Exception{
        Calendar c = getCalendar(yearMonth);
        c.add(Calendar.MONTH,1);
        c.set(Calendar.DATE,0);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        return format.format(c.getTime());
    }

    /**
     * 日历格式解析
     * @param yearMonth
     * @return
     * @throws Exception
     */
    private static Calendar getCalendar(String yearMonth) throws Exception{
        int year = 0;
        int month = 0;
        try{
            if(null!=yearMonth||yearMonth.trim().length()==6){
                year = Integer.parseInt(yearMonth.substring(0,4));
                month = Integer.parseInt(yearMonth.substring(4,6));
                if(month>12|| month<0 || year<0){
                    throw new Exception("格式不正确");
                }
            }
        }catch (Exception e){
            throw new Exception("格式不正确");
        }
        Calendar c = Calendar.getInstance();
        c.set(year,month-1,1);
        return c;
    }

    public static void main(String[] args) throws Exception{

        System.out.println("当前月\t"+currentMonth());
        System.out.println("上个月\t"+previousMonth());
        System.out.println("下个月\t"+nextMonth());
        System.out.println("指定月的上个月\t"+previousMonth("201808"));
        System.out.println("指定月的下个月\t"+nextMonth("201808"));

        System.out.println("当前月第一天\t"+firstDayOfMonth(currentMonth()));
        System.out.println("当前月最后一天\t"+lastDayOfMonth(currentMonth()));

        System.out.println("上月第一天\t"+firstDayOfMonth(previousMonth()));
        System.out.println("上月最后一天\t"+lastDayOfMonth(previousMonth()));

        System.out.println("下月第一天\t"+firstDayOfMonth(nextMonth()));
        System.out.println("下月最后一天\t"+lastDayOfMonth(nextMonth()));

        System.out.println("指定月第一天\t"+firstDayOfMonth("201808"));
        System.out.println("指定月最后一天\t"+lastDayOfMonth("201808"));

    }
}
