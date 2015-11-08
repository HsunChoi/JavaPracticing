package com.xun.java.practing.leetcode;

import java.util.Arrays;

/**
 * Created by cuixun on 8/10/15.
 */
public class NextPermutation {
    public static void main(String[]args){
        int[] a = {2, 3, 1};
        nextPermutation(a);
        Xun.print(a);
    }


    public static void nextPermutation(int[] nums) {
        int start = -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                start = i;
                break;
            }
        }
        if(start == -1){
            Arrays.sort(nums);
            return;
        }
        Arrays.sort(nums, start + 1, nums.length);

        for(int i = start + 1; i < nums.length; i++){
            if(nums[i] > nums[start]){
                int tmp = nums[i];
                nums[i] = nums[start];
                nums[start] = tmp;
                break;
            }
        }

    }
}
