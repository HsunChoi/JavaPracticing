package com.xun.java.practing.leetcode;

import java.util.Arrays;

/**
 * Created by cuixun on 8/1/15.
 */
public class AnagramWord {

    public static void main(String[]args){
        String a = "abcdef";
        String b = "aedbfc";
        System.out.println(isAnagram(a, b));
    }



    public static boolean isAnagram(String s, String t) {

        if((s.length() == 0 && t.length() == 0) || (s.equals(t))){
            return true;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        s = new String(s1);
        t = new String(t1);
        return s.equals(t);
    }
}
