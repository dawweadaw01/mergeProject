package cdu.zch.taglibs;
import java.text.SimpleDateFormat;

public class MyElFunctions {

    public static SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat sdfYMDHMS = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String formatDate(long time) {
        return sdfYMD.format(time);
    }

    public static String formatDatetime(long time) {
        return sdfYMDHMS.format(time);
    }
}