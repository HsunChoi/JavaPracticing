package com.xun.java.practing.careerup;

import org.junit.Test;

/**
 * Created by cuixun on 11/17/15.
 */
public class LongestPalindrome {
    public static void main(String[]args){

        String s = "qwertyuiopoiuyhgtrfde";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s){
        String palindrome = "";
        for(int i = 0; i < s.length() - 1; i++){
            String s1 = getLongPalindrome(s, i);
            String s2 = getLongPalindrome1(s, i, i + 1);
            String tmp = s1.length() > s2.length() ? s1 : s2;
            palindrome = palindrome.length() > tmp.length() ? palindrome : tmp;
        }

        return palindrome;
    }

    public static String getLongPalindrome(String s, int start){
        int i = 0;
        String res = "";
        while(start - i >= 0 && start + i < s.length()){
            if(s.charAt(start - i) == s.charAt(start + i)){
                res = s.substring(start - i, start + i + 1);
            }else{
                return res;
            }
            i++;
        }
        return res;
    }

    public static String getLongPalindrome1(String s, int left, int right){
        int i = 0;
        String res = "";
        while(left - i >= 0 && right + i < s.length()){
            if(s.charAt(left - i) == s.charAt(right + i)){
                res = s.substring(left - i, right + 1 + i);
            }else{
                return res;
            }
            i++;
        }
        return res;
    }
}
