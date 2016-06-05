package com.preparation.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class maxEnd3Test {

    @Test
    public void maxEnd3assertion1() {

        maxEnd3 me3 = new maxEnd3();
        int[] input1 = {1, 2, 3};
        int[] expected1 = {3, 3, 3};
        int[] actual1 = me3.maxEnd3(input1);
        assertArrayEquals(expected1,actual1);
    }

    @Test
    public void maxEnd3assertion2() {

        maxEnd3 me3 = new maxEnd3();
        int[] input2 = {11, 5, 9};
        int[] expected2 = {11, 11, 11};
        int[] actual2 = me3.maxEnd3(input2);
        assertArrayEquals(expected2,actual2);
    }

    @Test
    public void maxEnd3assertion3() {

        maxEnd3 me3 = new maxEnd3();
        int[] input3 = {2, 11, 3};
        int[] expected3 = {3, 3, 3};
        int[] actual3 = me3.maxEnd3(input3);
        assertArrayEquals(expected3,actual3);
    }
}
