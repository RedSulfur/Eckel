package com.preparation.algorithms.visualAlg;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class QuickSort {

    public static void main(String[] args) {

        int[] input = new int[]{1, 12, 5, 26, 7, 14, 3, 7, 2};

        QuickSort quickSort = new QuickSort();
        System.out.println("Unsorted: " + Arrays.toString(input));
        quickSort.sort(input, 0, input.length - 1);
        System.out.println("Sorted: " + Arrays.toString(input));
    }

    private void sort(int[] input, int low, int high) {

        int index = partition(input, low, high);

        if(low < index - 1) {
            sort(input, low, index - 1);
        }
        if(high > index) {
            sort(input, index, high);
        }
    }

    private int partition(int[] array, int i, int j) {

        int pivot = array[(i + j) / 2];

        while (i <= j) {

            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if(i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        return i;
    }
}
