package com.xun.java.practing.careerup.ReverseWordsInString.src;

import java.util.Scanner;

/**
 * Created by cuixun on 4/27/15.
 */
public class ReverseWordsInString {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();
        System.out.println(reverseWords(s));
    }

    /**
     *
     * @param s
     * @return
     */
    static String reverseWords(String s) {
        StringBuffer reversed = new StringBuffer();
        if (s.length() != 0) {
            for (int i = s.length() - 1, j = s.length(); i >= 0; i--) {
                if (!Character.isLetterOrDigit(s.charAt(i))) {
                    if (s.charAt(i) == ' ') {

                    } else {
                        reversed.append(s.charAt(i));
                    }
                    j = i;
                } else if (i == 0 || s.charAt(i - 1) == ' ') {
                    if (reversed.length() == 0) {
                        reversed.append("");
                    }
                    reversed.append(s.substring(i, j));
                    reversed.append(" ");
                }
            }
        }

        return new String(reversed);
    }

}
