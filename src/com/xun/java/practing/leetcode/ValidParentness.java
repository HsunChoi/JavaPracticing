package com.xun.java.practing.leetcode;

import java.util.Stack;

/**
 * Created by cuixun on 8/3/15.
 */
public class ValidParentness {

    public static void main(String[] args) {
        String s = "((";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        char tmp;
        char inside;
        while (s.length() != 0) {
            tmp = s.charAt(0);
            if (s.length() > 1 && (stack.isEmpty() || tmp == '(' || tmp == '[' || tmp == '{')) {
                stack.push(tmp);
            } else {
                inside = stack.pop();
                if (inside == '(' && tmp != ')' || inside == '[' && tmp != ']' || inside == '{' && tmp != '}') {
                    return false;
                }
            }
            s = s.substring(1);
        }

        return true;
    }


}

