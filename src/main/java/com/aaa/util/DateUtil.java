package com.aaa.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateUtil {
    //    获取当前时间戳
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public SimpleDateFormat simpleDateFormat() {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
