package com.xun.java.practing.leetcode;

import java.util.Scanner;

/**
 * Created by cuixun on 4/30/15.
 */
public class ReverseCharacters {
    public static void main(String[]args){
        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();
        System.out.println(reverse(s));
        System.out.println(recursion(s));
        System.out.println(reverseString(s));
    }

    public static String reverse(String s){
        if(s == null || s == ""){
            return null;
        }
        int len = s.length() - 1;
        StringBuffer reverse = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            reverse.append(s.charAt(len - i));
        }
        return new String(reverse);
    }

    static String recursion(String s){
        if(s == null || s.length() <= 1){
            return s;
        }
        return recursion(s.substring(1)) + s.substring(0,1);
    }

    static String reverseString(String s){
        if(s == null || s.length() == 0){
            return s;
        }
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        return sb.toString();
    }
}
