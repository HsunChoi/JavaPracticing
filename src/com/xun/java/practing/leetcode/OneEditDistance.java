package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 4/26/15.
 */
public class OneEditDistance {
    public static void main(String[] args) {
        String s1 = "qweretwuiop";
        String s2 = "qwertwuiop";
        System.out.println(isOneEditDistance(s1, s2));
    }


    static boolean isOneEditDistance(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 - length2 < 0) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
            length1 = s1.length();
            length2 = s2.length();
        }
        if (length1 - length2 > 1) {
            return false;
        }
        int diffCount = 0;
        if (length1 == length2) {
            for (int i = 0; i < length2; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diffCount++;
                    if (diffCount > 1) {
                        return false;
                    }
                }

            }
        }
        if (length1 - length2 == 1) {
            for (int i = 0, j = 0; j < length2; i++, j++) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    if (s1.charAt(i + 1) == s2.charAt(j)) {
                        diffCount++;
                        i++;
                    } else if (s1.charAt(i + 1) != s2.charAt(j)) {
                        return false;
                    }
                    if (diffCount > 1) {
                        return false;
                    }
                }
            }
        }


        return true;
    }
}
