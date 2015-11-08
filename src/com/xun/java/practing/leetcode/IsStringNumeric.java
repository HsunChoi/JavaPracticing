package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 4/24/15.
 */
public class IsStringNumeric {
    public static void main(String[]args){
        String s = "123.1324151d9876543";
        System.out.print(isNumeric(s));

    }

    public static boolean isNumeric(String s){
        int dotNum = 0;
        if(Character.isWhitespace(s.charAt(0)) || s.substring(0, 1).equals("+") || s.substring(0, 1).equals("-")){
            s = s.substring(1);
        }
        if(Character.isWhitespace(s.charAt(s.length() - 1))){
            s = s.substring(0, s.length() - 1);
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '.'){
                dotNum++;
                i++;
                if(dotNum > 1){
                    return false;
                }
            }
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
