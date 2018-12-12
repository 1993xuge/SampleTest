package com.xuge.sampletest.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created at 2018/12/11 上午10:50.
 *
 * @author yixu.wang
 */
public class Utils {
    public static String formateDateWithDefault() {
        return formatDate(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS");
    }

    public static String formatDate(long date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
        return format.format(new Date(date));
    }
}
