package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 5/22/15.
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p/>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p/>
 * For example,
 * Given input array nums = [1,1,2],
 * <p/>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[]args){

        int[] b = {1, 1, 1, 2, 2, 2, 3, 3, 3};
        int lenB = removeDuplicates(b);
        Xun.print(b, lenB);
        int[] a = {1, 1, 2, 3, 3, 3, 4, 5, 5, 5, 5};
        int length = removeDupliElem(a);
        Xun.print(a, length);

    }
    public static int removeDupliElem(int[] a){
        if(a.length <= 1){
            return a.length;
        }
        int length = 1;
        int tmp = a[0];
        for(int i = 0; i < a.length; i++){
            if(tmp != a[i]){
                a[length] = a[i];
                tmp = a[i];
                length++;

            }
        }
        return length;
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int length = 1;
        int count = 0;
        int tmp = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == tmp){
                count++;
                if(count < 2){
                    nums[length] = nums[i];
                    length++;
                }
            }else{
                count = 0;
                nums[length] = nums[i];
                tmp = nums[length];
                length++;
            }
        }

        return length;
    }
}
