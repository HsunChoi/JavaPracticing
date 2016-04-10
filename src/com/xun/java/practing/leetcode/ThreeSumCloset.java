package com.xun.java.practing.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuixun on 5/4/15.
 */
public class ThreeSumCloset {
    public static void main(String[]args){
        int[] a = {1, 3, 1, 5, 4};
        int res = threeSumClosest(a, 4);
            System.out.print(res + " ");

    }


    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int diff = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - target > diff){
                return res;
            }
            for(int j = i + 1, k = nums.length - 1; j < k;){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return sum;
                }
                int tmpDiff = Math.abs(sum - target);
                res = tmpDiff < diff ? sum : res;
                diff = Math.min(tmpDiff, diff);
                int left = nums[j];
                int right = nums[k];
                if(sum < target){
                    while(j < nums.length && left == nums[j]){
                        j++;
                    }
                }else{
                    while(k >= 0 && right == nums[k]){
                        k--;
                    }
                }
            }
        }
        return res;
    }



}
