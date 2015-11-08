package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 8/10/15.
 */
public class LongestValidParenthess {


    public static void main(String[] args) {
        String s = "((((((((((()))())))))()))()()(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((";

        long start = System.currentTimeMillis();
        int x = longestValidParentheses(s);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.print(x);
    }

    public static int longestValidParentheses(String s) {
        int result = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                int sum = 1;
                int j = i + 1;
                while (j < s.length() && sum >= 0) {
                    if (s.charAt(j) == '(') {
                        sum += 1;
                    } else if (s.charAt(j) == ')') {
                        sum -= 1;
                    }
                    if (sum == 0) {
                        result = Math.max(j - i + 1, result);
                    }
                    j++;
                }

            }
            i++;
        }
        return result;
    }

}
