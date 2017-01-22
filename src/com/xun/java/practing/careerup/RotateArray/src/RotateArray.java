package com.xun.java.practing.careerup.RotateArray.src;

import java.util.Arrays;

/**
 * Created by cuixun on 3/23/15.
 */
public class RotateArray {
    public static void main(String[]args){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        rotate(array, 17);
    }

    /**
     * Time complexity O(n);
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int[]b = new int[length];
        for(int i = 0; i < length; i++){
            b[i] = nums[i];
        }
        for(int i = 0, j = length - k; j < length; i++, j++){
            nums[i] = b[j];
        }
        for(int i = k, j = 0; i < length; i++, j++){
            nums[i] = b[j];
        }

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
