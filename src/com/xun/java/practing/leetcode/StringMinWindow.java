package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 6/24/15.
 */
public class StringMinWindow {
    public static void main(String[]args){
        String a = "bba";
        String b = "ba";
        System.out.println(minWindow(a, b));
    }

    public static String minWindow(String s, String t) {
        if(s.length() < t.length() || t.length() == 0 || s == null || t == null){
            return "";
        }
        int[] tWords = new int[256];
        int[] sWords = new int[256];
        int found = 0;
        int left = 0, right = 0;
        String res = "";
        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i < t.length(); i++){
            tWords[t.charAt(i)]++;
        }
        while(right < s.length()){
            if(found < t.length()){
                if(tWords[s.charAt(right)] > 0){
                    sWords[s.charAt(right)]++;
                    if(sWords[s.charAt(right)] <= tWords[s.charAt(right)]){
                        found++;
                    }
                }
                right++;
            }
            while(found >= t.length()){
                if(minLength >= right - left){
                    minLength = right - left;
                    res = s.substring(left, right);
                }
                if(tWords[s.charAt(left)] > 0){
                    sWords[s.charAt(left)]--;
                    if(sWords[s.charAt(left)] < tWords[s.charAt(left)]){
                        found--;

                    }
                }
                left++;
            }
        }
        return res;
    }
}
