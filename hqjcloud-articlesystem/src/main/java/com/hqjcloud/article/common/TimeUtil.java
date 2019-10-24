package com.hqjcloud.article.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.article.common
 * @ClassName: TimeUtil
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/24 15:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/24 15:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TimeUtil {

    public  final  static  String pattern="yyyy-MM-dd HH:mm:ss";

    public  final  static  String shortPattern="yyyy-MM-dd";


    /**
     * @Description 获取当前时间
     * @Param []
     * @Return java.lang.Long
     * @Author lic
     * @Date 2019/7/29
     * @Time 10:51
     */
    public static Long GetDate() {
        return new Date().getTime() / 1000;
    }

    /**
     * Date 类型转化为 String 类型
     *
     * @param date
     * @return yyyy-MM-dd HH:mm:ss 格式的时间
     */
    public static String dateToStringEx(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * Date 类型转化为 String 类型
     *
     * @param date
     * @return yyyy-MM-dd 格式的时间
     */
    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(shortPattern);
        return sdf.format(date);
    }

    /**
     * String 类型转化为 Date 类型
     *
     * @param strTime    String 类型时间
     * @param formatType 时间格式
     * @return Date 类型的时间
     * @throws ParseException
     */
    public static Date stringToDate(String strTime, String formatType) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    /**
     * String 类型数据转化为 Date 类型数据
     *
     * @param strTime String 类型时间
     * @return Date 类型时间，转换后忽略时分秒
     * @throws ParseException
     */
    public static Date stringToDate(String strTime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(shortPattern);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    /**
     * String 类型转化为 Date 类型
     *
     * @param strTime String 类型时间
     * @return Date 类型时间，转化后保存时分秒
     * @throws ParseException
     */
    public static Date stringToDate1(String strTime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }


    /**
     * 获取时分秒
     *
     * @param date
     * @return HH:mm:ss 格式的时分秒
     */
    public static String getTimeShort(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * Date 类型转化为 Long 类型
     *
     * @param date
     * @return
     */
    public static Long dateToLong(Date date) {
        try {
            if (null == date) {
                return 0L;
            }
            return date.getTime();
        } catch (Exception e) {
            return 0L;
        }

    }

    /**
     * Long 类型转化为 String 类型
     *
     * @param time
     * @return
     */
    public static Date longToDate(Long time) {
        try {
            if (time == null) {
                time = 0L;
            }
            return new Date(time);
        } catch (Exception e) {
            return null;
        }
    }


    public static void main(String[] args) {
        TimeUtil util = new TimeUtil();
        Date date = new Date();
        //System.out.println(util.getTimeShort(date));
        Long timeLong = date.getTime();
        System.out.println(timeLong);
        String t = "2017-01-12 12:11:01";
        String f = "yyyy-MM-dd";
        //System.out.println(stringToDate(t,f)); 1507772534344
        //System.out.println(stringToDate1(t));
        Long l = 1507772738542L;
        System.out.println(longToDate(l));
    }

}