package org.example.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatedAt {
    public static String createdAt() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String timeSatmp = format.format(date);

        return timeSatmp;
    }
}
