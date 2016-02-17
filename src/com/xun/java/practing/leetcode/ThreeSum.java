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
        List<List<Integer>> list1 = threeSum(a, sum);

        print(list);
        System.out.println();
        print(list1);
    }

    public static List<List<Integer>> findTriplets(int[] a, int sum) {
        Arrays.sort(a);
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = 0; i < a.length; i++) {
            if(a[i] > sum){
                break;
            }
            while(i > 0 && i < a.length && a[i] == a[i - 1]){
                i++;
            }
            for (int j = i + 1, k = a.length - 1; j < k;) {
                int left = a[j];
                int right = a[k];
                if (a[i] + a[j] + a[k] == sum) {
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(a[i]);
                    list.add(a[j]);
                    list.add(a[k]);
                    result.add(list);
                    while(j < a.length && a[j] == left){
                        j++;
                    }
                    while(k > 0 && a[k] == right){
                        k--;
                    }
                }else if(a[i] + a[j] + a[k] < sum){
                    while(j < a.length && a[j] == left){
                        j++;
                    }
                }else{
                    while(k > 0 && a[k] == right){
                        k--;
                    }
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

    public static List<List<Integer>> threeSum(int[] numbers, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(numbers == null || numbers.length == 0){
            return lists;
        }
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] > target){
                break;
            }
            while(i > 0 && i < numbers.length && numbers[i] == numbers[i - 1]){
                i++;
            }
            for(int j = i + 1, k = numbers.length - 1; j < k;){
                int left = numbers[j];
                int right = numbers[k];
                if(numbers[i] + numbers[j] + numbers[k] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[i]);
                    list.add(numbers[j]);
                    list.add(numbers[k]);
                    lists.add(list);
                    while(j < numbers.length && left == numbers[j]){
                        j++;
                    }
                    while(k >= 0 && right == numbers[k]){
                        k--;
                    }
                }else if(numbers[i] + numbers[j] + numbers[k] < target){
                    while(j < numbers.length && numbers[j] == left){
                        j++;
                    }
                }else{
                    while(k >= 0 && numbers[k] == right){
                        k--;
                    }
                }
            }
        }
        return lists;

    }
}
