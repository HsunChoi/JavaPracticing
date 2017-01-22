package com.xun.java.practing.leetcode;

import java.util.Stack;

/**
 * Created by cuixun on 8/10/15.
 */
public class LongestValidParenthess {


    public static void main(String[] args) {
        String s = "((((((((((()))())))))()))()()(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((";

        long start = System.nanoTime();
        int x = longestValidParentheses(s);
        long end = System.nanoTime();
        System.out.println((end - start) / 1000);
        System.out.print(x + "\n\n");

        long start1 = System.nanoTime();
        int x1 = longestValidParentheses1(s);
        long end1 = System.nanoTime();
        System.out.println((end1 - start1) / 1000);
        System.out.print(x1);

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

    public static int longestValidParentheses1(String s) {
        int res = 0;
        int tep = 0;
        Stack<Integer> s1 = new Stack<>();
        int data[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') s1.push(i);
            else {
                if (!s1.empty()) {
                    data[i] = 1;
                    data[s1.pop()] = 1;
                }
            }
        }
        for (int i : data) {
            if (i == 1) tep++;
            else {
                res = Math.max(tep, res);
                tep = 0;
            }
        }
        return Math.max(tep, res);
    }

}
