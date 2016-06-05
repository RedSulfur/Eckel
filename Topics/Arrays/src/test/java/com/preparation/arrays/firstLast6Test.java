package com.preparation.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

/*
        firstLast6({1, 2, 6}) → true
        firstLast6({6, 1, 2, 3}) → true
        firstLast6({13, 6, 1, 2, 3}) → false
*/



public class firstLast6Test {

    @Test
    public void testVaryingCapacity() {

        firstLast6 fl6 = new firstLast6();

        Integer[] input1 = new Integer[]{1, 2, 6};
        Integer[] input2 = new Integer[]{6, 1, 2, 3};
        Integer[] input3 = new Integer[]{13, 6, 1, 2, 3};

        boolean expected1 = true;
        boolean expected2 = true;
        boolean expected3 = false;

        boolean actual1 = fl6.firstLast6(input1);
        boolean actual2 = fl6.firstLast6(input2);
        boolean actual3 = fl6.firstLast6(input3);

        assertEquals(expected1,actual1);
        assertEquals(expected2,actual2);
        assertEquals(expected3,actual3);

    }

}
