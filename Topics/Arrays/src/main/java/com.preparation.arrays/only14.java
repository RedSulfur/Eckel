package com.preparation.arrays;

/*
        only14({1, 4, 1, 4}) → true
        only14({1, 4, 2, 4}) → false
        only14({1, 1}) → true
*/

public class only14 {

    public boolean only14(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1 && nums[i] != 4) {
                flag = false;
                System.out.println("flag: " + flag + " in case of i = " + i);
            }
        }
        return flag;
    }
}
