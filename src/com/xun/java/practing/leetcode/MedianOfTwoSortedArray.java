package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 7/30/15.
 */
public class MedianOfTwoSortedArray {
    public static void main(String[]args){
        int[] a = {};
        int[] b = {2, 3};
        System.out.println(findMedianSortedArrays(a, b));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] nums = new int[len];
        int even = len % 2 == 0 ? 1 : 0;
        int i = 0;
        int j = 0;
        int index = 0;
        int mid = len / 2;
        while(index <= mid && i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                nums[index] = nums1[i];
                i++;
            }else{
                nums[index] = nums2[j];
                j++;
            }
            index++;
        }
        while(index <= mid && i < nums1.length){
            nums[index] = nums1[i];
            i++;
            index++;
        }
        while(index <= mid && j < nums2.length){
            nums[index] = nums2[j];
            j++;
            index++;
        }
        return nums.length == 0 ? 0 : (double)(nums[mid] + nums[mid - even]) / 2;
    }
}
