package com.preparation.algorithms;

import static java.lang.String.format;

public class ArrayStructures {

    private int[] theArray = new int[50];

    private int arraySize = 10;

    public void generateRandomArray() {

        for (int i = 0; i < arraySize; i ++) {
            theArray[i] = (int) (Math.random()*10 + 10);
        }
    }

    public void printArray() {


        System.out.println("----------");
        for (int i = 0; i < arraySize; i ++) {

            System.out.println("| " + i + " | " + theArray[i] + " |");
            System.out.println("----------");

        }

    }

    public void bubbleSot() {

        for (int i = arraySize - 1; i > 0 ; i--) {

            for (int j = 0; j < i; j++) {

                if (theArray[j] > theArray[j + 1]) {
                    swapValues(j, j + 1);
                    printHorizArray(i, j);
                }
                printHorizArray(i, j);
            }

        }

    }


    public void swapValues(int indexOne, int indexTwo) {

        int temp;
        temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;

    }

    public void binarySearch(int value) {

        int minIndex = 0;
        int maxIndex = arraySize - 1;


        while (minIndex <= maxIndex) {

            int midIndex = (minIndex + maxIndex) / 2;

            printHorizArray(midIndex, -1);

            if(theArray[midIndex] < value) minIndex = midIndex + 1;

            else if(theArray[midIndex] > value) maxIndex = midIndex - 1;

            else {

                System.out.println("Found a match for " + value + " at index " + midIndex);
                minIndex = maxIndex + 1;
            }


        }

    }

    public void selectionSort() {

        for (int x = 0; x < arraySize; x++) {

            int minimum = x;

            for (int y = x; y < arraySize; y++) {

                if (theArray[minimum] > theArray[y]) {
                    minimum = y;
                }
            }
            swapValues(minimum,x);
            printHorizArray(x, -1);

        }


    }

    public void insertionSort() {

        for (int i = 1; i < arraySize; i++) {

            int j = i;

            int insertValue = theArray[i];

            while ((j > 0) && (theArray[j - 1] > insertValue)) {

                theArray[j] = theArray[j - 1];
                j--;
            }
            theArray[j] = insertValue;
            printHorizArray(i, j);

            System.out.println("\nArray [i] = " + theArray[i] +
            " Array[j] = " + theArray[j] + " toInsert = " + insertValue);

        }

    }


    public void printHorizArray(int m, int n) {

        for (int i = 0; i < 51; i++) {
            System.out.print("-");
        }

        System.out.println();

        for (int i = 0; i < arraySize; i++) {
            System.out.print("| " + format("%-2d", i) + " ");
        }

        System.out.println("|");


        for (int i = 0; i < 51; i++) {
            System.out.print("-");
        }

        System.out.println();
        for (int i = 0; i < arraySize; i++) {
            System.out.print("| " + theArray[i] + " ");
        }

        System.out.println("|");

        for (int i = 0; i < 51; i++) {
            System.out.print("-");
        }

        System.out.println();


        if(n != -1) {

            for(int k = 0; k < ((n*5) + 2); k++)System.out.print(" ");
            System.out.print(n);

        }

        if(m != -1) {

            for (int l = 0; l < (5 * (m - n) - 1); l++) System.out.print(" ");
            System.out.print(m);

        }
        System.out.println();

    }

    public int getValueAt(int index) {
        if(index < arraySize) return theArray[index];
        else return 0;
    }


    public boolean doesArrayContainThisValue (int value) {

        boolean valueInArray = false;

        for (int i = 0; i < arraySize; i++) {
            if (theArray[i] == value) {
                valueInArray = true;
            }
        }

        return valueInArray;
    }

    public void deleteIndexFromArray (int index) {

        if (index < arraySize) {

            for (int i = index; i < arraySize - 1; i++) {
                theArray[i] = theArray[i + 1];
            }
            arraySize--;
        }
    }

    public void addValue (int value) {

        if (arraySize < 50) {
            theArray[arraySize] = value;
        }
        arraySize++;
    }

    public String valueLinerSearch (int value) {

        boolean valueInTheArray = false;
        String indexesWithValue = "";

        System.out.print("The value was found in the following: ");
        for (int i = 0; i < arraySize; i++) {

            if (theArray[i] == value) {
                valueInTheArray = true;
                System.out.print(i + " ");
                indexesWithValue += i + " ";
            }
        }

        if (!valueInTheArray) {
            indexesWithValue += "None";
            System.out.print(indexesWithValue);
        }

        return indexesWithValue;
    }

    public static void main(String[] args) {

        ArrayStructures arrayStructures = new ArrayStructures();

        arrayStructures.generateRandomArray();
//        arrayStructures.bubbleSot();
//        arrayStructures.selectionSort();
        arrayStructures.insertionSort();
//        System.out.println("********This is where binary search starts*********");
//        arrayStructures.binarySearch(17);


    }

}
