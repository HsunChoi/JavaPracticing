package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by cuixun on 2/26/15.
 */
public class FindLongestPalindrome {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Please enter one string: ");
        String s = cin.nextLine();

        String out = findLongestPalin(s);

        String result = improveFind(s);
        System.out.println(out);
        System.out.println(result);

        String out2 = longestSubPalindrome(s);
        System.out.println(out2);

        String out3 = longestPalindrome(s);
        System.out.println(out3);

    }

    /**
     * The time complexity of this method is n^3, whick is to high for a string whose length is hundreds
     *
     * @param s
     * @return
     */
    public static String findLongestPalin(String s) {
        String subS = "";
        int count = 0;
        String longestPalindorme = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                subS = s.substring(i, j);
                if (subS.length() > count && isPalindrome(subS)) {
                    count = subS.length();
                    longestPalindorme = subS;

                }
            }
        }
        System.out.println(count);
        return longestPalindorme;
    }

    /**
     * Here is an another method, whose time complexity is n^2 but its space complexity is n^2 too.
     * Which may occupy a lot of spaces.
     *
     * @param s
     * @return
     */
    public static String improveFind(String s) {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        String longSubS = "";
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!stringArrayList.contains(s.substring(i, j + 1))) {
                    stringArrayList.add(s.substring(i, j + 1));
                }
            }
        }
        while (stringArrayList != null && !stringArrayList.isEmpty()) {
            String sub = stringArrayList.get(index);
            if (sub.length() > longSubS.length() &&
                    isPalindrome(sub)) {
                longSubS = sub;
            }
            stringArrayList.remove(index);

        }
        return longSubS;
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int last = s.length() - 1;
        while (last - start > 0) {
            if (s.charAt(start) != s.charAt(last)) {
                return false;
            }
            start++;
            last--;
        }
        return true;
    }

    /**
     * Time complexity is O(n^2)
     * @param s
     * @return
     */
    public static String longestSubPalindrome(String s){
        String longest = "";
        for(int i = 0; i < s.length(); i++){
            String tmp = palindromeExpand(s, i, i);
            if(tmp.length() > longest.length()){
                longest = tmp;
            }
            tmp = palindromeExpand(s, i, i + 1);
            if(tmp.length() > longest.length()){
                longest = tmp;
            }
        }
        return longest;
    }

    public static String palindromeExpand(String s, int l, int r){
        String result = "";

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            r++;
            result = s.substring(l, r);
            l--;
        }

        return result;
    }

    /**
     * Manacher Methods
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s == "" || s == null || s.length() == 0){
            return "";
        }else{
            s = intertS(s);
        }
        String sub = "";
        for(int i = 0; i < s.length(); i++){
            int j = 0;
            String tmp = "";
            while(i - j >= 0 && i + j < s.length()){
                if(s.charAt(i - j) == s.charAt(i + j)){
                    j++;
                }else{
                    break;
                }
            }
            tmp = s.substring(i - (j - 1), i + j);
            if(tmp.length() > sub.length()){
                sub = tmp;
            }
        }
        sub = regulate(sub);
        return sub;
    }
    static String intertS(String s){
        String r = "#";
        for(int i = 0; i < s.length(); i++){
            r = r + s.charAt(i) + "#";
        }
        return r;
    }
    static String regulate(String s){
        String r = "";
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 1){
                r = r + s.charAt(i);
            }
        }
        return r;
    }
}
