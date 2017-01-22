package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 4/22/16.
 */
public class MaxSubArray {
    public static void main(String[]args){
        int[] nums = {-1, -2, 1, 3, 4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int preSum  = nums[0];
        //int cur = 0;
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(preSum < 0){
                preSum = nums[i];
            }else{
                preSum = preSum + nums[i];
            }
            max = Math.max(preSum, max);
        }
        return max;
    }
}
