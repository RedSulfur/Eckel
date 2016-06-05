package com.preparation.arrays;

import java.util.Arrays;

/**
 * Created by sulfur on 02.04.16.
 */

/**
*@throws IndexOutOfBoundsException if starting position
 *in source or destination array is bigger than array.length
**/

public class make2 {

    /**
     * @param a - primary array
     * @param b - accessory array
     * @return array that is a composition of a and b
     */
    public int[] make2(int[] a, int[] b) {

        int capacity = 2 - a.length;
        int[] result = new int[2];

        System.arraycopy(a, 0, result, 0, a.length);

        System.arraycopy(b, 0, result, a.length, capacity);
        System.out.println(Arrays.toString(result));
        return result;
    }
}
