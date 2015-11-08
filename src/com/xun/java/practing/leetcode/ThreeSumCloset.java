package com.xun.java.practing.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuixun on 5/4/15.
 */
public class ThreeSumCloset {
    public static void main(String[]args){
        int[] a = {1, 3, 1, 5, 4};
        List<Integer> list = threeSumCloset(a, 4);
        for(int i:list){
            System.out.print(i + " ");
        }
    }

    /**
     * Some changes made from LeeCode
     * @param a
     * @param target
     * @return
     */
    public static List<Integer> threeSumCloset(int[] a, int target){
        Arrays.sort(a);
        List<Integer> result = findThreeSum(a, target);
        if(result != null && result.size() != 0){
            return result;
        }else{
           return threeSumCloset(a, target + 1);
        }


    }

    public static List<Integer> findThreeSum(int[] a, int sum){
        List<Integer> list = new LinkedList<Integer>();
        if(a.length < 3){
            return null;
        }
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1, k = a.length - 1; j < k;){
                if(a[i] + a[j] + a[k] == sum){
                    list.add(a[i]);
                    list.add(a[j]);
                    list.add(a[k]);
                    return list;
                }else if(a[i] + a[j] + a[k] < sum){
                    j++;
                }else{
                    k--;
                }
            }
        }
        if(list != null && list.size() != 0) {
            System.out.println(sum);
        }

            return list;
    }

    /**
     * Original solution in LeetCode, accepted.
     */
    class Solution {
        public int threeSumClosest(int[] a, int target) {
            Arrays.sort(a);
            if(isFindThreeSum(a, target)){
                return target;
            }
            int diff = 1;
            boolean isFind = false;
            while(!isFind){
                boolean left = isFindThreeSum(a, target - diff);
                boolean right = isFindThreeSum(a, target + diff);
                if(left){
                    return target - diff;
                }
                if(right){
                    return target + diff;
                }
                isFind = left || right;
                diff++;
            }
            return Integer.MAX_VALUE;
        }

        public boolean isFindThreeSum(int[] a, int sum){
            List<Integer> list = new LinkedList<Integer>();
            if(a.length < 3){
                return false;
            }
            for(int i = 0; i < a.length; i++){
                for(int j = i + 1, k = a.length - 1; j < k;){
                    if(a[i] + a[j] + a[k] == sum){

                        return true;
                    }else if(a[i] + a[j] + a[k] < sum){
                        j++;
                    }else{
                        k--;
                    }
                }
            }

            return false;
        }
    }


}
