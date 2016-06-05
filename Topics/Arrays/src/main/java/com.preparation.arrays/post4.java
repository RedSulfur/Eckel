package com.preparation.arrays;

import java.util.Arrays;

/**
 * Created by sulfur on 12.04.16.
 */
public class post4 {

    public int[] post4(int[] nums) {

        int[] result = nums;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                result = new int[nums.length - i];
                result = Arrays.copyOfRange(nums, i + 1, nums.length);
            }
        }

        return result;
    }
}
