package com.xun.java.practing.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuixun on 6/18/15.
 */
public class HappyNumber {
    public static void main(String[]args){
        int n = 7;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        List<Integer> list = new LinkedList<Integer>();
        return isHappy(n, list);
    }

    static boolean isHappy(int n, List<Integer> list){
        if(n <= 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        String s = Integer.toString(n);
        int[] a = new int[s.length()];
        for(int i = 0; i < a.length; i++){
            a[i] = Integer.parseInt(s.substring(i, i + 1));
        }
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i] * a[i];
        }
        if(sum == 1){
            return true;
        }
        if(list.contains(sum)){
            return false;
        }
        list.add(sum);
        return isHappy(sum, list);
    }
}
