package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuixun on 6/24/15.
 */
public class Subsets {

    public static void main(String[]args){
        int[] nums = {1, 2, 4, 9, 3, 5};
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        Xun.printList(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        if(nums.length == 0){
            return lists;
        }
        Arrays.sort(nums);
        lists.add(list);
        subsets(nums, lists, 0);
        return lists;
    }

    static void subsets(int[]nums, List<List<Integer>> lists, int start){
        if(start >= nums.length){
            return;
        }
        List<List<Integer>> nlists = new LinkedList<List<Integer>>(lists);
        for(int i = 0; i < nlists.size(); i++){
            List<Integer> l = new LinkedList<Integer>(nlists.get(i));
            l.add(nums[start]);
            if(!lists.contains(l)){
                lists.add(l);
            }
        }
        subsets(nums, lists, start + 1);
        return;
    }

}
