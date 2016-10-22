package com.preparation.algorithms.mergesort_vogella;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.currentTimeMillis;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

public class MergeSortTest {

    public static final Integer[] VALID_INPUT = new Integer[] {70, 40, 60, 80, 30};
    public static final Integer[] CORRECT_OUTPUT = new Integer[] {30, 40, 60, 70, 80};
//    public static final Integer[] VALID_INPUT = new Integer[] {9, 5, 1, 3};
//    public static final Integer[] CORRECT_OUTPUT = new Integer[] {1, 3, 5, 9};

    private Integer[] numbers;
    private static final int SIZE = 7;
    private static final int MAX = 20;

    @Before
    public void setUp() {
        Random rand = new Random();
        numbers = new Integer[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = rand.nextInt(MAX) + 1;
        }
    }

    @Test
    public void shouldReturnSortedArrayOnValidInput() {

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(VALID_INPUT);
        Integer[] sortedArray = mergeSort.getNumbers();

        Assert.assertThat(sortedArray, is(CORRECT_OUTPUT));
    }

    @Test
    public void testMergeSortPerformance() {

        long startTime = currentTimeMillis();
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(numbers);
        long elapsedTime = currentTimeMillis() - startTime;
        System.out.println("Elapsed time: " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] > numbers[i + 1]) {
                fail("Sort does not work properly");
            }
        }
    }

    @Test
    public void testStandardJavaSortPerformance() {

        long startTime = currentTimeMillis();
        Arrays.sort(numbers);
        long elapsedTime = currentTimeMillis() - startTime;
        System.out.println("Elapsed time: " + elapsedTime);


        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] > numbers[i + 1]) {
                fail("Sort does not work properly");
            }
        }
    }
}
