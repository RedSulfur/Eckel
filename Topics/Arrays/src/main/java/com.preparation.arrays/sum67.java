package com.preparation.arrays;

/**
 * Created by sulfur on 03.04.16.
 */
public class sum67 {

    public int sum67(int[] nums) {

        int flag = 1;
        int sum = 0;
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            sum +=nums[i];
            if(nums[i] == 6) {
                flag = flag*(-1);
            }
            if(flag == -1) {
                diff += nums[i];
            }
            if (nums[i] == 7) {
                flag = flag*(-1);
            }
        }

        sum = sum - diff;
        return sum;
    }
}
