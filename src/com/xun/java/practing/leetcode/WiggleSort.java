package com.xun.java.practing.leetcode;

import java.util.Arrays;

/**
 * Created by cuixun on 1/9/16.
 */
public class WiggleSort {


    public static void main(String[]args){
        int[] array = {1, 5, 1, 1, 6, 4};
        wiggleSort(array);
        Xun.print(array);
    }





    public static void wiggleSort(int[] nums) {
        int length = nums.length;
        int frontLength = length % 2 == 0 ? length / 2 - 1 : length / 2;
        Arrays.sort(nums);
        int[] buffer = new int[length];
        for(int i = 0; i < length; i++){
            buffer[i] = nums[i];
        }
        int index = 0;
        for(int i = 0; i <= frontLength; i++){
            nums[index] = buffer[frontLength - i];
            if(index + 1 < length){
                nums[index + 1] = buffer[length - i - 1];
            }
            index = index + 2;
        }

    }
}
