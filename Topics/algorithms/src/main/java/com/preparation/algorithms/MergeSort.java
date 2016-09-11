package com.preparation.algorithms;


import java.util.Arrays;

public class MergeSort {
    public static void main(String a[]) {

        int array[] = { 10, 8, 4, 80, 13, 1, 3, 11 };

        System.out.println(Arrays.toString(mergeSort(array)));

    }

    public static int[] mergeSort(int[] list) {

        if(list.length <= 1) {
            return list;
        }

        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, list);
        return list;
    }

    private static void merge(int[] first, int[] second, int[] result) {

        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while (iFirst < first.length
                && iSecond < second.length) {
            if(first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst++];
            } else {
                result[j] = second[iSecond++];
            }
            j++;
        }
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }
}