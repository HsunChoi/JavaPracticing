package com.xun.java.practing.leetcode;

import java.util.*;

/**
 * Created by cuixun on 5/4/15.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 1, 3, 4, 5, 3, 1, 2, 3, 4, 2, 4, 6, 7, 8, 9, 0, 0, 0, 9, 8, 6};
        int sum = 24;
        List<List<Integer>> list = findTriplets(a, sum);
        print(list);
    }

    public static List<List<Integer>> findTriplets(int[] a, int sum) {
        Arrays.sort(a);
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1, k = a.length - 1; j < k;) {
                if (a[i] + a[j] + a[k] == sum) {
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(a[i]);
                    list.add(a[j]);
                    list.add(a[k]);
                    if(!result.contains(list)) {
                        result.add(list);
                    }
                    j++;
                    k--;
                }else if(a[i] + a[j] + a[k] < sum){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;

    }

    static void print(List<List<Integer>> list) {
        for (List l : list) {
            println(l);
        }
    }

    static void println(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

    }
}
