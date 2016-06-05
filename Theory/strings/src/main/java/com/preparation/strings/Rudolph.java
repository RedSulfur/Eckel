package com.preparation.strings;

/**
 * Created by sulfur on 22.04.16.
 */
public class Rudolph {

    public static void main(String[] args) {

        for (String pattern : new String[]
                /*

                [ab] - любой из символов a или b
                [a-z] - любой символ от a до b
                . - любой символ
                re* - Matches 0 or more occurrences of preceding (предшествующий) expression.

                */
                {"Rudolph", "[rR]udolph", "[rR][aeiou][a-z]ol.*"}) {
            System.out.println("Rudolph".matches(pattern));
        }
    }
}
