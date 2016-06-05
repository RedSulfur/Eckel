package com.preparation.arrays;

/**
 * Created by sulfur on 02.04.16.
 */

public class centeredAverage {

    public int centeredAverage(int[] nums) {
        /*int sum = 0;
        int count_min = 0;
        int count_max = 0;
        int count = 0;
        int res_max = nums[0];
        int res_min = nums[0];

        for(int i = 0; i < nums.length - 1; i++) {
            int max = Math.max(nums[i],nums[i+1]);
            if(res_max < max) res_max = max;
            int min = Math.min(nums[i],nums[i+1]);
            if(res_min > min) res_min = min;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == res_min) {
                System.out.println("Min increment invoked at " + nums[i]);
                count_min++;
            }
            if(nums[i] == res_max) {
                System.out.println("Max increment invoked at " + nums[i]);
                count_max++;
            }
            if(nums[i] != res_max && nums[i] != res_min) {
                sum += nums[i];
                System.out.println("Adding value to sum " + nums[i]);
                count++;
            }
        }
        if(count_min == 2) {
            count++;
        }

        System.out.println("res_min:" + res_min);
        System.out.println("res_max:" + res_max);
        System.out.println(sum);
        System.out.println(count);
        System.out.println(count_min);
        System.out.println(count_max);*/

        int max = nums[0];
        int min = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }

        System.out.println("max value :" + max);
        System.out.println("min value :" + min);
        System.out.println("sum before decreasing: " + sum);
        System.out.println("nums.length" + (nums.length - 2));
        double d = (sum - (max + min))/5.0;
        System.out.println(d);

        return (sum - (max + min)) / (nums.length - 2);
    }
//        return sum/count;
    }
//}

