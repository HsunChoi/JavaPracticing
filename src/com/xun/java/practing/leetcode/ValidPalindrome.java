package com.xun.java.practing.leetcode;

import java.util.Scanner;

/**
 * Created by cuixun on 3/27/15.
 */
public class ValidPalindrome {
    public static void main(String[]args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Please enter one sentence: ");
        String str = cin.nextLine();
        if (isPalindrome(str)) {
            System.out.println("This is a valid palindrome.");
        }else{
            System.out.println("This is not a valid palindrome");
        }

    }

    public static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length() - 1;
        while (i < j){
            while(i < j && !Character.isLetterOrDigit(str.charAt(i))){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(str.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
