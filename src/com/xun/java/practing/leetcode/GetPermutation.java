package com.xun.java.practing.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by cuixun on 6/15/15.
 */
public class GetPermutation {
    public static void main(String[]args){
        int[] nums = {1, 1};
        List<List<Integer>> lists = new LinkedList<>();
        lists = permuteUnique(nums);
        Xun.printList(lists);
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
        if(nums.length == 0){
            return lists;
        }
        List<Integer> list = new LinkedList<Integer>();
        list.add(nums[0]);
        lists.add(list);
        lists = getPer(nums, 1, lists, map);
        return lists;
    }

    static List<List<Integer>> getPer(int[]nums, int index, List<List<Integer>> lists, Map<List<Integer>, Integer> map){
        if(index >= nums.length){
            return lists;
        }
        List<List<Integer>> nlists = new LinkedList<List<Integer>>();
        for(List<Integer> l : lists){
            for(int i = 0; i <= l.size(); i++){
                LinkedList<Integer> nl = new LinkedList<>(l);
                nl.add(i, nums[index]);
                if(!nlists.contains(nl)){
                    nlists.add(nl);
                }
            }
        }
        return getPer(nums, index + 1, nlists, map);
    }
}
