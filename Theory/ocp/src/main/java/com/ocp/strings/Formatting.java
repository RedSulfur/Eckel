package com.ocp.strings;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Formatting {
    public static void main(String[] args) {
        getCurrentDate();
        dateAndTimeCalculations();
        dateAndTimeCalculationsOnDifferentLocales();
        dateAndTimeCalculationsInDifferentLocalesWithFormatting();
        formatNumbersAndCurrenciesAcrossDifferentLocales();
    }

    public static void getCurrentDate() {
        Date date = new Date();
        System.out.println(date.toString());
    }

    //TODO: erra - drift
    public static void dateAndTimeCalculations() {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.add(Calendar.MONTH, 1);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(df.format(calendar.getTime()));
    }

    public static void dateAndTimeCalculationsOnDifferentLocales() {
        Locale locale = new Locale("EN");
        Calendar calendar = Calendar.getInstance(locale);
        calendar.add(Calendar.MONTH, 2);
        DateFormat df = DateFormat
                .getDateInstance(DateFormat.FULL, locale);
        System.out.println(df.format(calendar.getTime()));
    }

    public static void dateAndTimeCalculationsInDifferentLocalesWithFormatting() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -2);
        Locale locale = new Locale("DE");
        Date date = calendar.getTime();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        String formattedDate = df.format(date);
        System.out.println(formattedDate);
    }

    public static void formatNumbersAndCurrenciesAcrossDifferentLocales() {
        double amount = 700;
        Locale locale = new Locale("UA");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        String formattedAmount = nf.format(amount);
        System.out.println(formattedAmount);
    }
}
