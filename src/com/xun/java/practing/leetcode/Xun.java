package com.xun.java.practing.leetcode;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by cuixun on 5/22/15.
 */
public class Xun {
    /**
     * print the elements
     * @param a
     */
    public static void print(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void print(Integer[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void print(String[] strings){
        for(int i = 0; i < strings.length; i++){
            System.out.print(strings[i] + ",");
        }
        System.out.println();
    }
    /**
     * print the elements form 0 to end;
     * @param a
     * @param end
     */
    public static void print(int[] a, int end){
        if(end > a.length){
            throw new IllegalArgumentException("ArrayOutOfBound");
        }
        for(int i = 0; i < end; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void printString(List<String> list){
        for(String s:list){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void printInteger(List<Integer> list){
        for(Integer s:list){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void printMatrix(int[][] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length; j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printList(List<List<Integer>> lists){
        for(List l : lists){
            for(int i = 0; i < l.size(); i++){
                System.out.print(l.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void print(char[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void printMatrix(char[][] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length; j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printListNodes(ListNode node){
        ListNode head = node;
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printHashmap(Map<Integer, Character> map){
        for(Object key : map.keySet()){
            System.out.print(key + ":" + map.get(key) + "  ");
        }
        System.out.println();
    }

    public static void printTreemap(TreeMap<Integer, Character> map){
        for(Object key : map.keySet()){
            System.out.print(key + ":" + map.get(key) + "  ");
        }
        System.out.println();
    }



}
