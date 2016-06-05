package com.preparation.strings;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by sulfur on 22.04.16.
 */
public class SplitDemo {

    /*
    Метод split() разбивает входную строку по совпадениям регулярного выражения
    и возвращает массив обьектов String
    */

    private static String regex = "!!";
    private static String text = "Some!!unusual usage!!of!!exclamation!!mark";

    public static void main(String[] args) {

        Pattern p = Pattern.compile(regex);

        System.out.println(Arrays.toString(p.split(text)));

        System.out.println(Arrays.toString(p.split(text,3)));


    }
}
