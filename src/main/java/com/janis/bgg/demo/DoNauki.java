package com.janis.bgg.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DoNauki {
    public static void main(String[] args) throws ParseException {
        String data = "02 10 2019 20:01:44";
        String pattern = "dd MM yyyy HH:mm:ss";
        String pattern2 = "EEE, dd MMM yyyy HH:mm:ss Z";
        String data2 = "Wed, 02 Oct 2019 20:01:44 +0000";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern2).withLocale(Locale.ENGLISH);
        SimpleDateFormat format = new SimpleDateFormat(pattern2, Locale.ENGLISH);
        Date date = format.parse(data2);
        LocalDateTime lastUpdateDate = LocalDateTime.parse(data2, formatter);
        System.out.println(date + " " + lastUpdateDate);
    }
}
