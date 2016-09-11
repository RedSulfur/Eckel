package com.preparation.algorithms;

import java.util.Arrays;

public class SortAlgorithms {

    public static void bubbleSort(Comparable[] values) {

        int arraySize = values.length;
        for (int i = arraySize - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if(values[j].compareTo(values[j + 1]) > 0) {
                    swapValues(j, j + 1, values);
                }
            }
        }
    }

    public static void binarySearch(Comparable key, Comparable[] values) {

        int arraySize = values.length;
        int lowIndex = 0;
        int highIndex = arraySize - 1;

        while (lowIndex <= highIndex) {
            int mediumIndex = (lowIndex + highIndex) / 2;
            if(values[mediumIndex].compareTo(key) > 0) {
                highIndex = mediumIndex - 1;
            } else if(values[mediumIndex].compareTo(key) < 0) {
                lowIndex = mediumIndex + 1;
            } else {
                System.out.println("Your key was found: values" + "["
                        + mediumIndex + "] = " + values[mediumIndex]);
                lowIndex = highIndex + 1;
            }
        }
    }

    private static void swapValues(int index1, int index2, Comparable[] values) {
        Comparable temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }

    public static void main(String[] args) {

        Integer[] integers = new Integer[] {5, 6, 19, 7, 18, 19, 3, 1, 15, 4};
        bubbleSort(integers);
        System.out.println(Arrays.toString(integers));
        binarySearch(18, integers);
    }
}
