package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuixun on 6/26/15.
 */
public class SummaryRanges {

    public static void main(String[]args){
        int[] nums = {Integer.MIN_VALUE, Integer.MIN_VALUE + 1, Integer.MAX_VALUE};
        Xun.printString(summaryRanges(nums));

    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if(nums.length == 0){
            return list;
        }
        sumRanges(nums, list, 0);
        return list;
    }

    static void sumRanges(int[] nums, List<String> list, int start){
        if(start >= nums.length){
            return;
        }
        int end = start;
        StringBuffer s = new StringBuffer();
        for(int i = start + 1; i < nums.length; i++){
            if(Math.abs(nums[i] - nums[i - 1]) != 1){
                break;
            }
            end++;
        }
        if(end - start == 0){
            s.append(nums[start]);
        }else{
            s.append(nums[start]);
            s.append("->");
            s.append(nums[end]);
        }
        list.add(new String(s));
        sumRanges(nums, list, end + 1);
    }
}
