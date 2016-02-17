package com.xun.java.practing.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cuixun on 2/13/16.
 */
public class SlidingWindowsMaximum {

    public static void main(String[]args){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] max = maxSlidingWindow(nums, 3);

        Xun.print(max);

    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0){
            return nums;
        }
        PriorityQueue<Integer> pq = new PriorityQueue(new LargeToSmallComparator());
        int[] max = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++){
            pq.offer(nums[i]);
        }
        max[0] = pq.peek();
        int index = 1;
        for(int i = k; i < nums.length; i++){
            pq.remove(nums[i - k]);
            pq.offer(nums[i]);
            max[index] =  pq.peek();
            index++;
        }
        return max;
    }


}


class LargeToSmallComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer i1, Integer i2){
        return -(i1 - i2);
    }
}
