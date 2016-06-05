package com.preparation.strings;

/**
 * Created by sulfur on 19.04.16.
 */
public class Immutable {

    public static String upper(String s) {

        return s.toUpperCase();
    }

    public static void main(String[] args) {

        String q = "Some String";
        System.out.println(upper(q));
        System.out.println(q);


    }
}
