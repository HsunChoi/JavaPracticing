package com.xun.java.practing.leetcode;

import java.util.Arrays;

/**
 * Created by cuixun on 5/9/15.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {

        String s = "aaaaaaa";
        String p = "aaaaa..";
        System.out.println(expressionMatching(s, p));
    }

    public static boolean expressionMatching(String s, String p) {
        boolean[] match = new boolean[s.length() + 1];
        Arrays.fill(match, false);
        match[s.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) == '*') {
                for (int j = s.length() - 1; j >= 0; j--) {
                    match[j] = (match[j] || match[j + 1] && (p.charAt(i - 1) == '.' || s.charAt(j) == p.charAt(i - 1)));
                }
                i--;
            } else {
                for (int j = 0; j < s.length(); j++){
                    match[j] = (match[j + 1] && (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j)));
                }
                match[s.length()] = false;
            }
        }
        return match[0];


    }
}
