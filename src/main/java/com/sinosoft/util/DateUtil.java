package com.sinosoft.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2021/9/14 15:17
 */
public class DateUtil {
    /**
     * 声明日志对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 标准日期时间类型
     */
    public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 标准日期时间类型
     */
    public static final String DATE = "yyyy-MM-dd";

    /**
     * 时间戳类型
     */
    public static final String TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";

    public static Timestamp getSystemDateTime(int millionSecond) {
        return new Timestamp(Calendar.getInstance().getTimeInMillis() - millionSecond);
    }

    public static String timestampToString(Timestamp timestamp, String format) {
        try {
            if (timestamp != null) {
                DateFormat dateFormat = new SimpleDateFormat(format);
                return dateFormat.format(timestamp);
            } else {
                return null;
            }
        } catch (Exception e) {
            LOG.error("转换日期失败，失败原因：" + e.getMessage());
            return null;
        }
    }

    public static Timestamp stringToTimestamp(String datetime, String format) {
        try {
            if (datetime != null && !datetime.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                Date date = sdf.parse(datetime);
                return new Timestamp(date.getTime());
            } else {
                return null;
            }
        } catch (Exception e) {
            LOG.error("转换日期失败，失败原因：" + e.getMessage());
            return null;
        }
    }

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME);
        return sdf.format(new Date());
    }

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        return sdf.format(new Date());
    }

    public static String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP);
        return sdf.format(new Date());
    }

    public static String getCurrentTimeByPattern(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }

    public static String getSpecDate(int addDay) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, addDay);
        return sdf.format(calendar.getTime());
    }

}
