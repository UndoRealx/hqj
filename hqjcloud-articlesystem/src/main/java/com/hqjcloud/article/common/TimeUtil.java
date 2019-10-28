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

    /** 时间格式(yyyy-MM-dd HH:mm:ss) */
    public  final  static  String DATE_TIME_PATTERN="yyyy-MM-dd HH:mm:ss";

    /** 时间格式(yyyy-MM-dd) */
    public  final  static  String DATE_PATTERN="yyyy-MM-dd";

    /** 时间格式(HH:mm:ss) */
    public  final  static  String TIME_PATTERN="HH:mm:ss";


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


    public static String dateTimeFormat(Date date) {
           return dateFormatByPattern(date,DATE_TIME_PATTERN);
    }

    private  static  String dateFormatByPattern(Date date,String pattern)
    {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * Date 类型转化为 String 类型
     *
     * @param date
     * @return yyyy-MM-dd 格式的时间
     */
    public static String dateFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        return sdf.format(date);
    }

    /**
     * 获取时分秒
     *
     * @param date
     * @return HH:mm:ss 格式的时分秒
     */
    public static String timeFormat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(TIME_PATTERN);
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * String 类型转化为 Date 类型
     *
     * @param strTime    String 类型时间
     * @param pattern 时间格式
     * @return Date 类型的时间
     * @throws ParseException
     */
    public static Date ConvertToDate(String strTime, String pattern) throws ParseException {
        if (strTime.isEmpty()){
            return null;
        }
        SimpleDateFormat fmt = new SimpleDateFormat(pattern);
        return fmt.parse(strTime);
    }

    /**
     * String 类型数据转化为 yyyy-MM-dd 格式的时间
     *
     * @param strTime String 类型时间
     * @return Date 类型时间，转换后忽略时分秒
     * @throws ParseException
     */
    public static Date ConvertToDate(String strTime) throws ParseException {
        return ConvertToDate(strTime,DATE_PATTERN);
    }

    /**
     * String 类型数据转化为(yyyy-MM-dd HH:mm:ss) 格式的时间
     *
     * @param strTime String 类型时间
     * @return Date 类型时间，转化后保存时分秒
     * @throws ParseException
     */
    public static Date ConvertToDateTime(String strTime) throws ParseException {
        return ConvertToDate(strTime,DATE_TIME_PATTERN);
    }


    /**
    *@Description String 类型数据转化为 HH:mm:ss 格式的时间
    *@Param  * @param strTime
    *@Return java.util.Date
    *@Author lic
    *@Date 2019/10/25
    *@Time 16:53
    */
    public static Date ConvertToTime(String strTime) throws ParseException {
        return ConvertToDate(strTime,TIME_PATTERN);
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
    *@Description  Long时间转 字符串 格式字定义
    *@Param  * @param time
 * @param pattern
    *@Return java.lang.String
    *@Author lic
    *@Date 2019/10/25
    *@Time 17:04
    */
    public  static  String longToString(Long time,String pattern)
    {
        Date date=longToDate(time);
        if(null==date)
        {
            return  null;
        }
        return  dateFormatByPattern(date,pattern);
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