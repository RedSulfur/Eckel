package com.preparation.strings;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sulfur on 22.04.16.
 */
public class ReFlags {

    private static String text = "java has regex\nJava has regex\n" +
            "JAVA has pretty good regular expressions\n " +
            "Regular expressions are in JAVA";

    public static void main(String[] args) {

        Matcher m = Pattern.compile("^java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE)
                .matcher(text);

        while (m.find()) {
            System.out.println(m.group());
        }

    }


}
