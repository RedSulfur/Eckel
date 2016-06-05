package com.preparation.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

/*
        make2({4, 5}, {1, 2, 3}) → {4, 5}
        make2({4}, {1, 2, 3}) → {4, 1}
        make2({}, {1, 2}) → {1, 2}
*/

public class make2Test {

    @Test
    public void make2Test1() {
        make2 mk2 = new make2();

        int[] input1_1 = {4, 5};
        int[] input1_2 = {1, 2, 3};

        int[] expected = {4, 5};

        int[] actual = mk2.make2(input1_1,input1_2);
        assertArrayEquals(expected,actual);

    }

    @Test
    public void make2Test2() {
        make2 mk2 = new make2();

        int[] input2_1 = {4};
        int[] input2_2 = {1, 2, 3};

        int[] expected = {4, 1};

        int[] actual = mk2.make2(input2_1,input2_2);
        assertArrayEquals(expected,actual);

    }

    @Test
    public void make2Test3() {
        make2 mk2 = new make2();

        int[] input3_1 = {};
        int[] input3_2 = {1, 2};

        int[] expected = {1, 2};

        int[] actual = mk2.make2(input3_1,input3_2);
        assertArrayEquals(expected,actual);

    }

}
