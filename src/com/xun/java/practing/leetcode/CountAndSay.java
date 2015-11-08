package com.xun.java.practing.leetcode;

import java.util.Scanner;

/**
 * Created by cuixun on 5/6/15.
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p/>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * <p/>
 * Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Input n here: ");
        int n = cin.nextInt();
        System.out.println(count(n));
    }

    public static String count(int n){
        if(n == 1){
            return "1";
        }
        String  s = count(n - 1);
        StringBuffer result = new StringBuffer();
        int count = 1;
        char last = s.charAt(0);
        char tmp;
        for(int i = 1; i < s.length(); i++){
            tmp = s.charAt(i);
            if(tmp == last){
                count++;
            }else{
                result.append(count);
                result.append(last);
                count = 1;
                last = tmp;
            }
        }
        result.append(count);
        result.append(last);
        return new String(result);
    }
}
