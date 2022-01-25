package com.ndangducbn.apachepoi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
    public static String getStrDate(Long time, String format) {
        return new SimpleDateFormat(format).format(new Date(time));
    }
}
