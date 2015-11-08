package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 6/29/15.
 */
public class WildcardMatching {

    public static void main(String[]args){
        String s = "aaaaaaaaaaaa";
        String s1 = "aaaa?aa?a**?aa";
        System.out.println(isMatch(s, s1));
    }


    public static boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return true;
        if (p.replace("*", "").length() > s.length()) //pass TLE
            return false;

        int row = s.length();
        int col = p.length();

        boolean[][] match = new boolean[row+1][col+1];


        match[0][0] = true;

        for (int i = 1; i <= col && p.charAt(i-1) == '*'; i++){
            match[0][i] = true;
        }

        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= col; j++){
                if (p.charAt(j-1) == '*'){
                    match[i][j] = match[i-1][j-1] || match[i-1][j] || match[i][j-1];
                }
                else if (p.charAt(j-1) == '?'){
                    match[i][j] = match[i-1][j-1];
                }
                else{
                    match[i][j] = match[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1);
                }
            }
        }

        return match[row][col];
    }
}
