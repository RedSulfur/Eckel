package com.preparation.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resetting {

    public static void main(String args[]) {

        Pattern pattern = Pattern.compile("[frb][aiu][gx]");
        Matcher matcher = pattern.matcher("fix the rug with bags");

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
        System.out.println();
        /*
        Существующий метод Match может быть приминен к новой символьной последовательности
        при помощи метода reset()
        */
        matcher.reset("rix the bix with bux");
        System.out.println("After resetting the Matcher");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }

}
