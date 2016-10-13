package com.preparation.algorithms.pre;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        Integer[] integers = new Integer[] {1, 9, 3, 7, 5, 4, 5, 1, 2, 6};

        mergeSort(integers);
        System.out.println(Arrays.toString(integers));
    }

    private static Comparable[] mergeSort(Comparable[] list) {

        if(list.length <= 1) {
            return list;
        }

        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];

        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, list);
        return list;
    }

    private static void merge(Comparable[] first, Comparable[] second, Comparable[] list) {

        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].compareTo(second[iSecond]) < 0) {
                list[j] = first[iFirst];
                iFirst++;
            } else {
                list[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        System.arraycopy(first, iFirst, list, j, first.length - iFirst);
        System.arraycopy(second, iSecond, list, j, second.length - iSecond);
    }
}
