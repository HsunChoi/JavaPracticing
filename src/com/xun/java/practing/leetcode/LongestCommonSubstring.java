package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 1/18/16.
 */
public class LongestCommonSubstring {
    public static void main(String[]args){
        String a = "abcdaksndiansde";
        String b = "ebcr";
        System.out.println(longestCommonSubstring(a, b));
    }

    public static int longestCommonSubstring(String a, String b) {
        // write your code here
        int length = a.length() > b.length() ? b.length() : a.length();
        int size = 0;
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j <= length; j++){
                String substring = b.substring(i, j);
                if(a.contains(substring) && substring.length() > size){
                    size = substring.length();
                }
            }
        }
        return size;

    }
}
