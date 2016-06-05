package com.preparation.algorithms;

import java.util.Arrays;

public class ShellSort {

    public void sort() {

        

    }


    public static void main(String[] args) {

        ShellSort theSort = new ShellSort(10);

        System.out.println(Arrays.toString(theSort.theArray));

        theSort.sort();

        System.out.println(Arrays.toString(theSort.theArray));

    }

    private int[] theArray;

    private int arraySize;

    ShellSort(int arraySize) {

        this.arraySize = arraySize;

        theArray = new int[arraySize];

        generateRandomArray();

    }

    public void generateRandomArray() {

        for (int i = 0; i < arraySize; i++) {

            // Generate a random array with values between
            // 10 and 59

            theArray[i] = (int) (Math.random() * 50) + 10;

        }

    }

    public void printHorzArray(int i, int j, int h) {

        if (i == j)
            i = i - h;

        for (int n = 0; n < 51; n++)
            System.out.print("-");

        System.out.println();

        for (int n = 0; n < arraySize; n++) {

            System.out.print("| " + n + "  ");

        }

        System.out.println("|");

        for (int n = 0; n < 51; n++)
            System.out.print("-");

        System.out.println();

        for (int n = 0; n < arraySize; n++) {

            System.out.print("| " + theArray[n] + " ");

        }

        System.out.println("|");

        for (int n = 0; n < 51; n++)
            System.out.print("-");

        System.out.println();

        if (i != -1) {

            // Number of spaces to put before the F

            int spacesBeforeFront = 5 * i + 1;

            for (int k = 0; k < spacesBeforeFront; k++)
                System.out.print(" ");

            System.out.print("I");

            // Number of spaces to put before the R

            int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;

            for (int l = 0; l < spacesBeforeRear; l++)
                System.out.print(" ");

            System.out.print("O");

            System.out.println("\n");

        }

    }

}