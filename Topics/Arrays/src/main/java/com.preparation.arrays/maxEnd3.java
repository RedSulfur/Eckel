package com.preparation.arrays;

import java.util.Arrays;

/**
 * Created by sulfur on 01.04.16.
 */
public class maxEnd3 {

    public int[] maxEnd3(int[] nums) {

        /*int max = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > max) max = nums[i];
        }
        for(int i = 0; i < nums.length - 1; i++) {
            nums[i] = max;
        }
        return nums;*/

        int max;
        if(nums[0] > nums[nums.length - 1]) {
            max = nums[0];
        } else {
            max = nums[nums.length - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = max;
        }
        System.out.println(Arrays.toString(nums));
        return nums;

    }
}
