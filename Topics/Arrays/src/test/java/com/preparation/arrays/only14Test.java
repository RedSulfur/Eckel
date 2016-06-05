package com.preparation.arrays;

import org.junit.Test;

/**
 * Created by sulfur on 03.04.16.
 */
public class only14Test {

    @Test
    public void test1() {

        only14 o14 = new only14();
        int[] input = new int[]{1, 4, 1, 4};
        boolean expected = true;
        boolean actual = o14.only14(input);
        org.junit.Assert.assertEquals(expected,actual);

    }

    @Test
    public void test2() {

        only14 o14 = new only14();
        int[] input = new int[]{1, 4, 2, 4};
        boolean expected = false;
        boolean actual = o14.only14(input);
        org.junit.Assert.assertEquals(expected,actual);

    }
    @Test
    public void test3() {

        only14 o14 = new only14();
        int[] input = new int[]{1, 1};
        boolean expected = true;
        boolean actual = o14.only14(input);
        org.junit.Assert.assertEquals(expected,actual);

    }


}
