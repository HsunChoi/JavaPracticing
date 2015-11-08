package com.xun.java.practing.leetcode;

import java.util.Scanner;

/**
 * Created by cuixun on 3/22/15.
 */
public class UniqCharInString {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        System.out.println("Please enter a string: ");
        String str = cin.nextLine();
        System.out.println();
        System.out.println(isStringUnique(str));

    }

    /**
     * isStringUnique is a method that judge whether the chars in the string is the only one or not;
     *
     * @param str
     * @return
     */
    public static boolean isStringUnique(String str) {
        boolean[] char_set = new boolean[256];
        int val;
        for (int i = 0; i < str.length(); i++) {
            val = str.charAt(i);
            //System.out.print(val + " ");
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }


        return true;
    }

}
