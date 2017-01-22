package com.xun.java.practing.leetcode;

import static java.lang.System.out;

/**
 * Created by cuixun on 4/9/16.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrapingRainWater {

    public static void main(String[]args){

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        out.println(trapping(height));
    }


    public static int trapping(int[] height){
        if(height.length < 3){
            return 0;
        }

        int start = 0;
        int end = height.length - 1;
        int area = 0;

        while(start < end){
            if(height[start] < height[end]){
                int smaller = height[start];
                while(start <= end && smaller >= height[start]){
                    area += smaller - height[start];
                    start++;
                }
            }else{
                int smaller = height[end];
                while(start <= end && smaller >= height[end]){
                    area += smaller - height[end];
                    end--;
                }

            }
        }

        return area;

    }


}
