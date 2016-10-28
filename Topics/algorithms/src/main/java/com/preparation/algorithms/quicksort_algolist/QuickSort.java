package com.preparation.algorithms.quicksort_algolist;

import sun.misc.LRUCache;

import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

public class QuickSort {

    int i, j, pivot;

    public static void main(String[] args) {

        int[] input = new int[]{1, 12, 5, 26, 7, 14, 3, 7, 2};

        System.out.println("Unsorted array: " + Arrays.toString(input));
        System.out.println();
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(input, 0, input.length - 1);
        System.out.println();
        System.out.println("Sorted array: " + Arrays.toString(input));
    }

    public void quickSort(int array[], int left, int right) {
        int index = partition(array, left, right);

        // Stackoverflow if index is not decremented by 1
        // Because there is not out from the recursion
        // when there is only one element in the partial
        // array left
        if(left < index - 1) {
            quickSort(array, left, index - 1);
        }
        if(right > index) {
            quickSort(array, index, right);
        }
    }

    private int partition(int[] array, int left, int right) {

        i = left;
        j = right;
        pivot = array[(left + right) / 2];
        System.out.println("Pivot: " + pivot);

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            /*
            the following if statement is mandatory because otherwise
            values will be swapped after i variable enters the part
            of the array where there are only values bigger than pivot.
            So the array will remain unsorted.
            (In quick sort algorithm array is divided in two parts
            and after each iteration there are only values lesser than
            pivot in one half and values bigger than pivot in another)
             */
            System.out.println(Arrays.toString(array));
            if(i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        System.out.println("******************************");
        System.out.println(Arrays.toString(array));
        System.out.println("Returning index i = " + i);
        System.out.println("Returning index j = " + j);
        if(i > -1 && j > -1) {
            System.out.println("arr[i]  = " + array[i]);
            System.out.println("arr[j]  = " + array[j]);
        }
        System.out.println();

        return i;
    }
}
