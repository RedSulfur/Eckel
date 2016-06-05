package com.preparation.io;

import java.util.Arrays;

/**
 * Created by sulfur on 22.04.16.
 */
public class Splitting {

    private static String text = "Undo these chains, my friend... " +
            "...I'll show you the rage I've hidden.";

    public static void split(String regex) {
        System.out.println(Arrays.toString(text.split(regex)));
    }

    public static void main(String[] args) {

        split(" ");
        split("\\W+"); // разбиение по символам, не являющимся символами слова
        split("e\\W+");
    }
}
