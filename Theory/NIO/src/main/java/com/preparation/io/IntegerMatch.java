package com.preparation.io;

/**
 * Created by sulfur on 22.04.16.
 */
public class IntegerMatch {

    public static void main(String[] args) {

        int i = 5;
        /*

         В регулярных выражениях цифра обозначается \d
         \ - обратная косая черта регулярного выражения, значит следующий
        символ имеет специальное значение.
        + - одно или несколько повторений предшествующего выражения
        -? необязательный знак "минус"
        так как символ + имеет особый смысл в регулярных выражениях, его необходимо экранировать //

        */
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-?|\\+)\\d+"));
    }


}
