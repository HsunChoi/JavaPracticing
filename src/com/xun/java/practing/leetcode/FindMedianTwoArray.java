package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 6/15/15.
 */
public class FindMedianTwoArray {
    public static void main(String[]args){
        int[] a = {};
        int[] b = {1, 2, 3, 4};
        System.out.println(findMedianSortedArrays(a, b));
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int mid = (length1 + length2) / 2;
        if(length1 + length2 <= 1){
            if(length1 == 0 && length2 != 0){
                return nums2[mid];
            }else if(length1 != 0 && length2 == 0){
                return nums1[mid];
            }else{
                return 0;
            }
        }
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        int even = 0;
        double[] nums = new double[length1 + length2];
        if((length1 + length2) % 2 == 0){
            even = 1;
        }else{
            even = 0;
        }
        while(i <= mid){
            if(i1 >= length1){
                nums[i] = nums2[i2];
                i2++;
            }else if(i2 >= length2){
                nums[i] = nums1[i1];
                i1++;
            }
            else if(nums1[i1] < nums2[i2]){
                nums[i] = nums1[i1];
                i1++;
            }else if(nums1[i1] > nums2[i2]){
                nums[i] = nums2[i2];
                i2++;
            }

            i++;
        }

        return (nums[mid] + nums[mid - even]) / 2;
    }
}
