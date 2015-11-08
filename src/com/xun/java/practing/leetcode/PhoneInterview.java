package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by cuixun on 4/29/15.
 * some google interview questions
 */
public class PhoneInterview {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        String x = cin.nextLine();
        /**
         * find the minimum integer who is larger than s, and the left part of the s equals the right part of the s.
         */
        System.out.println(assignment1(x));
        int[] a = {1, 2, 2, 1, 2};
        int[] continusArray = {1, 2, 3, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 32, 12, 32, 2, 3, 4};
        /**
         * return how many methods could separate an int array, and both sides should have all the elements

         */
        System.out.println(methodsEqualSeperateIntArray(a));
        /**
         * return the longest consecutive sub-array of an int array
         * with two methods
         */
        longestContinusSubList(continusArray);
    }

    /**
     * find the minimum integer who is larger than s, and the left part of the s equals the right part of the s.
     *
     * @param s
     * @return
     */
    public static int assignment1(String s) {
        int x = Integer.parseInt(s);
        if (x < 0) {
            x = -x;
        }
        int digitNum = 0;
        int i = x;
        while (i != 0) {
            i /= 10;
            digitNum++;
        }
        if (digitNum % 2 != 0) {
            x = (int) Math.pow(10, digitNum);
            digitNum++;
        }
        int halfNum = digitNum / 2;
        double right = 0, left = 0;
        for (int j = x + 1; j < 10 * x; j++) {
            int y = (int) Math.pow(10, halfNum);
            left = j % y;
            right = j / y;
            if (right == left) {
                return j;
            }

        }

        return Integer.MAX_VALUE;
    }

    /**
     * return how many methods could separate an int array, and both sides should have all the elements
     * @param array
     * @return
     */
    public static int methodsEqualSeperateIntArray(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (isCharacterEqual(array, i)) {
                count++;
            }
        }


        return count;
    }


    public static boolean isCharacterEqual(int[] array, int line) {
        boolean[] left = new boolean[10];
        boolean[] right = new boolean[10];

        for (int i = 0; i <= line; i++) {
            left[array[i]] = true;
        }
        for (int i = line + 1; i < array.length; i++) {
            right[array[i]] = true;
        }
        for (int i = 0; i < left.length; i++) {
            if (left[i] != right[i]) {
                return false;
            }
        }

        return true;

    }

    /**
     * return the longest consecutive sub-array of an int array
     * @param a
     * @return
     */
    public static ArrayList<Integer> longestContinusSubList(int[] a){
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> result2 = longSubList(a, 0);
        for(int i = 0; i < a.length - 1; i++){
            if(a[i + 1] - a[i] == 1){
                if(!list.contains(a[i])) {
                    list.add(a[i]);
                }
                list.add(a[i + 1]);
                if(list.size() > result.size()){
                    result = list;
                }
            }else{
                list = new ArrayList<Integer>();
            }
        }

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
        for(int i = 0; i < result2.size(); i++){
            System.out.print(result2.get(i) + " ");
        }
        return result;
    }
    /**
     * recursion methods
     */
    public static ArrayList<Integer> longSubList(int[] a, int start){
        if(start < a.length - 1) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(a[start]);
            while (start + 1 < a.length && a[start + 1] - a[start] == 1) {
                result.add(a[start + 1]);
                start++;
            }
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            if(start + 1 < a.length) {
                tmp = longSubList(a, start + 1);
            }
            if (result.size() > tmp.size()) {
                return result;
            }
            return tmp;
        }
        return null;
    }


}
