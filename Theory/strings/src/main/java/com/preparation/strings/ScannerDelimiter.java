package com.preparation.strings;

import java.util.Scanner;

/**
 * Created by sulfur on 23.04.16.
 */
public class ScannerDelimiter {

    public static void main(String[] args) {

        Scanner sc = new Scanner("12, 51, 421 , 41, 51");
        sc.useDelimiter("\\s*,\\s*");

        while (sc.hasNext()) {
            System.out.println(sc.nextInt());
        }

    }

}
