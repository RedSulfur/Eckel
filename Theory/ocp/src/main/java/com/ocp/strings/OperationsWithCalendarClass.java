package com.ocp.strings;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class OperationsWithCalendarClass {
    public static void main(String[] args) {
        convertFromDateToCalendarAndBack();
        System.out.println();
        subtractMonthsFromCurrentDate();
        System.out.println();
        displayDateMutatedWithRollMethod();
    }

    private static void subtractMonthsFromCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -2);
        Locale locale = new Locale("RU");
        Date currentDate = calendar.getTime();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        String formattedDate = df.format(currentDate);
        System.out.println(formattedDate);
    }

    public static void convertFromDateToCalendarAndBack() {
        Date date = new Date();
//        Locale locale = new Locale("RU");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        System.out.println("Is sunday by my JVM considered to " +
                "be a first day of the week: "
                + (Calendar.SUNDAY == calendar.getFirstDayOfWeek()));

        System.out.println("Current day of the week: "
                + calendar.get(Calendar.DAY_OF_WEEK));

        Date currentDate = calendar.getTime();
        System.out.println(currentDate.toString());
    }

    public static void displayDateMutatedWithRollMethod() {
        Calendar calendar = Calendar.getInstance();
        Locale locale = new Locale("EN");
        calendar.roll(Calendar.MONTH, 15);

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        Date currentDate = calendar.getTime();
        String formattedDate = df.format(currentDate);
        System.out.println(formattedDate);
    }
}
