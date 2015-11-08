package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 8/10/15.
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class SearchRoatedSortedArray {

    public static void main(String[]args){

    }

    static int search(int[]nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        return search(nums, target, 0, nums.length);
    }

    static int search(int[] nums, int target, int left, int right){
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[left] == target){
            return left;
        }
        if(nums[right] == target){
            return right;
        }
        if(nums[left] < nums[mid]){
            if(target > nums[left] && target < nums[mid]){
                return search(nums, target, left + 1, mid - 1);
            }else{
                return search(nums, target, mid + 1, right - 1);
            }
        }else{
            if(target < nums[right] && target > nums[mid]){
                return search(nums, target, mid + 1, right - 1);
            }else{
                return search(nums, target, left + 1, mid - 1);
            }
        }
    }

}
