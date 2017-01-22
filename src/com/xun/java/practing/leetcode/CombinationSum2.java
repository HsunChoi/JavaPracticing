package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuixun on 4/9/16.
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        int[] nums = {13, 23, 25, 11, 7, 26, 14, 11, 27, 27, 26, 12, 8, 20, 22, 34, 27, 17, 5, 26, 31, 11, 16, 27, 13, 20, 29, 18, 7, 14, 13,
                15, 25, 25, 21, 27, 16, 22, 33, 8, 15, 25, 16, 18, 10, 25, 9, 24, 7, 32, 15, 26, 30, 19};
        int target = 25;

        List<List<Integer>> lists = combinationSum2(nums, target);

        Xun.printList(lists);

        Runnable r = () -> {

        };

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);

        int start = 0;
        int curSum = 0;

        dfs(candidates, target, lists, list, start, curSum);

        return (lists);

    }


    static void dfs(int[] candidates, int target, List<List<Integer>> lists, List<Integer> list, int start, int curSum){
        if(curSum == target){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(start >= candidates.length || curSum > target){
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if((i > start && candidates[i] == candidates[i - 1])){
                continue;
            }
            if(candidates[i] > target){
                break;
            }
            list.add(candidates[i]);
            dfs(candidates, target, lists, list, i + 1, curSum + candidates[i]);
            list.remove(list.size() - 1);
        }

    }
}
