package com.preparation.arrays;

/*
        sum67({1, 2, 2}) → 5
        sum67({1, 2, 2, 6, 99, 99, 7}) → 5
        sum67({1, 1, 6, 7, 2}) → 4
*/

import org.junit.Test;

public class sum67Test {

    @Test
    public void test1() {

        sum67 s67 = new sum67();
        int[] input = new int[] {1, 2, 2};
        int expected = 5;
        int actual = s67.sum67(input);

        org.junit.Assert.assertEquals(expected,actual);

    }

  @Test
    public void test2() {

        sum67 s67 = new sum67();
        int[] input = new int[] {1, 2, 2, 6, 99, 99, 7};
        int expected = 5;
        int actual = s67.sum67(input);

        org.junit.Assert.assertEquals(expected,actual);

    }

    @Test
    public void test3() {

        sum67 s67 = new sum67();
        int[] input = new int[] {1, 1, 6, 7, 2};
        int expected = 4;
        int actual = s67.sum67(input);

        org.junit.Assert.assertEquals(expected,actual);

    }


}
