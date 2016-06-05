package com.preparation.io;

/**
 * Created by sulfur on 22.04.16.
 */
public class Replacing {

    private static String text = "Undo these chains, my friend... " +
                         "...I'll show you the rage I've hidden. Undo";

    public static void main(String[] args) {
        /*

        + - одно или несколько повторений предшествующего выражения
        w - символ слова

        */

        System.out.println(text.replaceAll("U\\w+","Destroy"));
        System.out.println(text.replaceFirst("U\\w+", "Destroy"));

    }

}
