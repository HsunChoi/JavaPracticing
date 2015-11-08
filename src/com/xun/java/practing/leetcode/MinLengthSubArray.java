package com.xun.java.practing.leetcode;

import java.util.Comparator;
import java.util.List;

/**
 * Created by cuixun on 7/17/15.
 */
public class MinLengthSubArray {

    public static void main(String[]args){
        int[] a = new int[100];

    }

    /**
     * Two pointers, one slow, one fast, move forward the fast the pointer until the sum no less than s.
     * @param nums
     * @param s
     * @return
     */
    static int minLength(int[] nums, int s){
        int i = 0, j = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while(j < nums.length){
            sum += nums[j];
            while(sum >= s){
                min = Math.min(min, j - i + 1);
                sum -= nums[i];
                i--;
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }



}

