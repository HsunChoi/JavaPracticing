package com.xun.java.practing.leetcode;

import java.util.*;

/**
 * Created by cuixun on 2/13/16.
 */
public class FourSum {
    public static void main(String[]args){
        int[] nums = {-3,-1,0,2,4,5};
        int target = 0;
        List<List<Integer>> list = fourSum(nums, target);
        Xun.printList(list);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Set<List<Integer>> sets = new HashSet<List<Integer>>();
        if(nums == null || nums.length == 0){
            return lists;
        }
        Arrays.sort(nums);
        for(int i = 0, j = nums.length - 1; i < j;){
            int curTarget = target - nums[i] - nums[j];
            Set<Integer> set = new HashSet<Integer>();
            for(int k = i + 1; k < j; k++){
                if(!set.contains(curTarget - nums[k])){
                    set.add(nums[k]);
                }else{
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(curTarget - nums[k]);
                    list.add(nums[k]);
                    list.add(nums[j]);
                    if(sets.add(list)){
                        lists.add(list);
                    }
                }
            }
            if(nums[i] + nums[j] < target){
                i++;
            }else{
                j--;
            }
        }
        return lists;
    }
}
