package com.ocp.strings;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DateParsing {
    public static void main(String[] args) {
        Locale locale = new Locale("DE");
        Date date = new Date(1_000_000_000_000L);
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        String formattedDate = df.format(date);
        System.out.println("String representation of trillions millis date: "
                + formattedDate);
        try {
            Date parsedDate = df.parse(formattedDate);
            System.out.println("Date obtained by parsing string: "
                    + parsedDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
