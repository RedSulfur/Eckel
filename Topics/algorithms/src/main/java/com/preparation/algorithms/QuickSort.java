package com.preparation.algorithms;


import java.util.Arrays;

// The Quick Sort is normally the fastest sorting algorithm

public class QuickSort {

    private static int[] theArray;

    private static int arraySize;

    public static void main(String[] args) {

        QuickSort theSort = new QuickSort(10);

        theSort.generateRandomArray();

        System.out.println(Arrays.toString(QuickSort.theArray));

        theSort.quickSort(0, 9);

        System.out.println(Arrays.toString(QuickSort.theArray));

    }

    QuickSort(int newArraySize) {

        arraySize = newArraySize;

        theArray = new int[arraySize];

        generateRandomArray();

    }

    public void quickSort(int left, int right) {

        if (right - left <= 0) {
            return;
        } else {

            int pivot = theArray[right];

            int pivotPosition = partitionArray(left, right, pivot);

            quickSort(left,pivotPosition - 1);
            quickSort(pivotPosition + 1, right);
        }

    }

    public int partitionArray(int left, int right, int pivot) {

        int leftPointer = left - 1;

        int rightPointer = right;

        while (true) {

            while (theArray[++leftPointer] < pivot)
            ;

            while (theArray[--rightPointer] > pivot && rightPointer > 0)
            ;


            if (leftPointer >= rightPointer) {
                break;
            } else {

                swapValues(leftPointer, rightPointer);

            }
        }
        swapValues(leftPointer,right);
        return leftPointer;

    }

    public void swapValues(int indexOne, int indexTwo) {

        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;

    }

    public void generateRandomArray() {

        for (int i = 0; i < arraySize; i++) {

            // Generate a random array with values between
            // 10 and 59

            theArray[i] = (int) (Math.random() * 50) + 10;

        }

    }

    static void printHorzArray(int i, int j) {

        for (int n = 0; n < 61; n++)
            System.out.print("-");

        System.out.println();

        for (int n = 0; n < arraySize; n++) {

            System.out.format("| %2s " + " ", n);

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++)
            System.out.print("-");

        System.out.println();

        for (int n = 0; n < arraySize; n++) {

            System.out.print(String.format("| %2s " + " ", theArray[n]));

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++)
            System.out.print("-");

        System.out.println();

        if (i != -1) {

            // Number of spaces to put before the F

            int spacesBeforeFront = 6 * (i + 1) - 5;

            for (int k = 0; k < spacesBeforeFront; k++)
                System.out.print(" ");

            System.out.print("L" + i);

            // Number of spaces to put before the R

            int spacesBeforeRear = 5 * (j + 1) - spacesBeforeFront;

            for (int l = 0; l < spacesBeforeRear; l++)
                System.out.print(" ");

            System.out.print("R" + j);

            System.out.println("\n");

        }

    }

}
