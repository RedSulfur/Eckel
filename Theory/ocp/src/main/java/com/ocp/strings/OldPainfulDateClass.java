package com.ocp.strings;

import java.util.Date;

public class OldPainfulDateClass {
    public static void main(String[] args) {
        displayTrillionDateMillis();
        displayDateWhichIsOneHourPlusTrillionDate();
    }

    public static void displayTrillionDateMillis() {
        Date date = new Date(1_000_000_000_000L);
        System.out.println(date.toString());
    }

    public static void displayDateWhichIsOneHourPlusTrillionDate() {
        Date date = new Date(1_000_000_000_000L);
        date.setTime(date.getTime() + 36_00_000L);
        System.out.println(date.toString());
    }
}
