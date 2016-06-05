package com.preparation.arrays;

/*
        centeredAverage({1, 2, 3, 4, 100}) → 3
        centeredAverage({1, 1, 5, 5, 10, 8, 7}) → 5
        centeredAverage({-10, -4, -2, -4, -2, 0}) → -3
*/

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class centeredAverageTest {

    @Test
    public void test1() {
        centeredAverage ca = new centeredAverage();

        int[] input = new int[]{1, 2, 3, 4, 100};
        int expected = 3;
        int actual = ca.centeredAverage(input);
        assertEquals(expected,actual);
    }

    @Test
    public void test2() {
        centeredAverage ca = new centeredAverage();

        int[] input = new int[]{1, 1, 5, 5, 10, 8, 7};
        int expected = 5;
        int actual = ca.centeredAverage(input);
        assertEquals(expected,actual);
    }

    @Test
    public void test3() {
        centeredAverage ca = new centeredAverage();

        int[] input = new int[]{-10, -4, -2, -4, -2, 0};
        int expected = -3;
        int actual = ca.centeredAverage(input);
        assertEquals(expected,actual);
    }

}
