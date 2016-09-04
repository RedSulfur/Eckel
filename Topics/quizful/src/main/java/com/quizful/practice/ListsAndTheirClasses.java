package com.quizful.practice;

import java.util.ArrayList;

public class ListsAndTheirClasses {

    public static void main(String[] args) {
        Class stringClass = new ArrayList<String>().getClass();
        Class integerClass = new ArrayList<Integer>().getClass();

        System.out.println(stringClass);
        System.out.println(integerClass);
        System.out.println(stringClass == integerClass);
    }
}
