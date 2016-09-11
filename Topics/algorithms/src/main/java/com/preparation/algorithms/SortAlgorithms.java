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

    public static void selectionSort(Comparable[] values) {

        int arraySize = values.length;

        for(int x = 0; x < arraySize; x++) {
            int minimum = x;
            for(int y = x; y < arraySize; y++) {
                if(values[minimum].compareTo(values[y]) > 0) minimum = y;
            }
            swapValues(x, minimum, values);
        }
    }

    public static void insertionSort(Comparable[] values) {

        int arraySize = values.length;

        for(int i = 1; i < arraySize; i++) {
            Comparable temp = values[i];
            int j = i;
            while((j > 0) && (values[j - 1].compareTo(temp)) > 0) {
//                5, 6, 19, 7, 18, 19, 3, 1, 15, 4
                values[j] = values[j - 1];
                j--;
            }
            values[j] = temp;
        }
    }

    private static void swapValues(int index1, int index2, Comparable[] values) {
        Comparable temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }

    public static void main(String[] args) {

        Integer[] integers = new Integer[] {5, 6, 19, 7, 18, 19, 3, 1, 15, 4};
//        bubbleSort(integers);
//        selectionSort(integers);
        insertionSort(integers);
        System.out.println(Arrays.toString(integers));
        binarySearch(15, integers);
    }
}
