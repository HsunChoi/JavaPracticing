package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuixun on 7/29/15.
 */
public class DiffWaysToCompute {
    public static void main(String[]args){
        String s = "15*7+6-24";
        List<Integer> list = diffWaysToCompute(s);
        Xun.printInteger(list);
    }

    public static List<Integer> diffWaysToCompute(String s) {
        List<Integer> list = new ArrayList<Integer>();
        if(s == null || s.length() == 0){
            return list;
        }
        s = s.replaceAll(" ", "");
        int num = numOfOperators(s); // return the number of operators in string s;
        diffToCompute(s, list, num); //void add valid num to list
        return list;
    }

    static void diffToCompute(String s, List<Integer> list, int num){
        if(s == null || s.length() == 0){
            return;
        }
        if(num == 0){
            int x = Integer.parseInt(s);
            if(!list.contains(x)){
                list.add(x);
            }
            return;
        }
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++){
            if(i != 0 && !Character.isDigit(s.charAt(i))){
                right = getRight(s, i + 1); // return the index of next operator if no ? return s.length;
                int x = compute(s, left, i, right); // return the value of the expression;
                String front = s.substring(0, left);
                String back = right == s.length() ? "" : s.substring(right, s.length());
                String nextS = front + x + back;
                diffToCompute(nextS, list, num - 1);
                left = i + 1;
                i = right - 1;
            }
        }
    }

    static int numOfOperators(String s){
        int num = 0;
        for(int i = 1;i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                num++;
                i++;
            }
        }
        return num;
    }

    static int getRight(String s, int start){
        for(int i = start + 1; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                return i;
            }
        }
        return s.length();
    }

    static int compute(String s, int start, int index, int end){
        int x = Integer.parseInt(s.substring(start, index));
        int y = Integer.parseInt(s.substring(index + 1, end));
        if(s.charAt(index) == '+'){
            return x + y;
        }
        if(s.charAt(index) == '-'){
            return x - y;
        }
        if(s.charAt(index) == '*'){
            return x * y;
        }
        return 0;
    }
}
