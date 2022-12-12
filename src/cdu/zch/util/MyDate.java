package cdu.zch.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
    static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat sdfDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String d(Date date) {
        return sdfDate.format(date);
    }
    public static String d(long date) {
        return sdfDate.format(date);
    }
    public static String dt(Date date) {
        return sdfDatetime.format(date);
    }
    public static String dt(long date) {
        return sdfDatetime.format(date);
    }
    public static String now() {
        return sdfDatetime.format(new Date());
    }
    public static String today() {
        return sdfDate.format(new Date());
    }
}