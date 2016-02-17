package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 3/27/15.
 */
public class Strstr {
    public static void main(String[]args){
        String str = "mississippi";
        String target = "pi";
        System.out.println(strStr(str, target));
        System.out.println(str.indexOf(target));

    }
    public static int strStr(String haystack, String needle) {
        if(haystack == null){
            return -1;
        }
        if(haystack.equals(needle)){
            return 0;
        }
        int x = haystack.length();
        int y = needle.length();
        for(int i = 0; i < x - y + 1; i++){
            if(needle.equals(haystack.substring(i, i + y))){
                return i;
            }
        }
        return -1;
    }
}
