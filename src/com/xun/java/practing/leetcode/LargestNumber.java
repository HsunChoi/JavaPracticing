package com.xun.java.practing.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by cuixun on 7/1/15.
 */
public class LargestNumber {
    public static void main(String[]args){
        int[] nums = {121, 12323};
        System.out.println(largestNumber(nums));

    }

    static String largestNumber(int[] nums){
        StringBuffer sb = new StringBuffer();
        Integer[] a = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++){
            a[i] = nums[i];
        }
        Comparator l = new lComparator();
        Arrays.sort(a, l);
        for(int i = 0; i < a.length; i++){
            sb.append(a[i]);
        }
        return new String(sb);
    }

}

 class lComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer n, Integer n2){
        int[]d1 = Integer.toString(n).chars().map(c -> c-='0').toArray();
        int[]d2 = Integer.toString(n2).chars().map(c -> c-='0').toArray();
        int i = 0;
        int j = 0;
        int loop1 = 0;
        int loop2 = 0;
        while(loop1 < 2 || loop2 < 2){
            if(d1[i] > d2[j]){
                return -1;
            }else if(d1[i] < d2[j]){
                return 1;
            }
            if(i != d1.length - 1){
                i++;
            }else{
                i = 0;
                loop1++;
            }
            if(j != d2.length - 1){
                j++;
            }else{
                j = 0;
                loop2++;
            }
        }

        return 0;

    }
}
