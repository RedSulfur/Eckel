package com.topics.practice;

import java.util.Scanner;

public class MinAndMaxSubstring {

    public static void main(String[] args) {
        System.out.println("Please, enter the input string and a partition length");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int delim = in.nextInt();
        System.out.println(input);
        System.out.println(delim);
        String min = input.substring(0, delim);
        String max = input.substring(0, delim);
        for(int i = 1; i < input.length() - delim + 1; i++) {
            if(min.compareTo(input.substring(i, i + delim)) > 0) {
                min = input.substring(i, i + delim);
            }
            if(max.compareTo(input.substring(i, i + delim)) < 0) {
                max = input.substring(i, i + delim);
            }
        }
        System.out.println(min);
        System.out.println(max);
    }

}
