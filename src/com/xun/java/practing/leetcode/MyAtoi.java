package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 2/12/16.
 */
public class MyAtoi {
    public static void main(String[]args){
        String s = "   010";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        str = str.trim();
        int start = 0;
        int sign = 1;
        long result = 0;
        if(str.charAt(start) == '-'){
            sign = -1;
            start++;
        }
        else if(str.charAt(start) == '+'){
            start++;
        }
        for(int i = start; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return (int)result * sign;
            }
            result = result * 10 + (str.charAt(i) - '0');
            if(result * sign > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if( result * sign < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return sign * (int)result;
    }
}
