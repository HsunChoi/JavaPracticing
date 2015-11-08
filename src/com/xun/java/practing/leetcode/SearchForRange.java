package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 8/11/15.
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class SearchForRange {



    public int[] searchRange(int[] nums, int target) {
        int[] r = {-1, -1};
        if(nums == null || nums.length == 0){
            return r;
        }
        return search(nums, target, 0, nums.length - 1, r);
    }

    static int[] search(int[]nums, int target, int left, int right, int[] r){
        if(left > right){
            return r;
        }
        int mid = (left + right) / 2;
        if(nums[mid] == target){
            return range(nums, mid, r);
        }
        if(target < nums[mid]){
            return search(nums, target, left, mid - 1, r);
        }else{
            return search(nums, target, mid + 1, right, r);
        }
    }

    static int[] range(int[]nums, int index, int[] r){
        int target = nums[index];
        int left = index;
        int right = index;
        while(left >= 0 && nums[left] == target){
            left--;
        }
        while(right < nums.length && nums[right] == target){
            right++;
        }
        r[0] = left + 1;
        r[1] = right - 1;
        return r;
    }
}
