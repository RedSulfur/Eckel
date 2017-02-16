package com.ocp.strings;

import java.text.DateFormat;
import java.util.Date;

public class DateFormatInstancesDemo {
    public static void main(String[] args) {
        DateFormat df1 = DateFormat.getDateTimeInstance();
        DateFormat df2 = DateFormat.getDateInstance();
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.MEDIUM);
        DateFormat df5 = DateFormat.getDateInstance(DateFormat.LONG);
        DateFormat df6 = DateFormat.getDateInstance(DateFormat.FULL);

        Date date = new Date(1_000_000_000_000L);
        System.out.println(df1.format(date));
        System.out.println(df2.format(date));
        System.out.println(df3.format(date));
        System.out.println(df4.format(date));
        System.out.println(df5.format(date));
        System.out.println(df6.format(date));
    }
}
