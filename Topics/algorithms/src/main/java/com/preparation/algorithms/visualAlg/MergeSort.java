package com.preparation.algorithms.visualAlg;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] input = new int[]{1, 12, 5, 26, 7, 14, 3, 7, 2};

        MergeSort mergeSort = new MergeSort();
        System.out.println("Unsorted: " + Arrays.toString(input));
        mergeSort.sort(input);
        System.out.println("Sorted: " + Arrays.toString(input));
    }

    private int[] sort(int[] list) {

        if (list.length <= 1) {
            return list;
        }

        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];

        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        sort(first);
        sort(second);

        merge(list, first, second);

        return list;
    }

    private void merge(int[] result, int[] first, int[] second) {

        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while (iFirst < first.length &&
                iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }
}
