package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 3/3/16.
 */
public class AtoiIII {


    public static void main(String[]args){
        System.out.println(atoi("  -21477hjv6"));
    }

    public static int atoi(String str) {
        // write your code here
        int count = 0;
        str = str.trim();
        int sign = 1;
        long res = 0;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(count > 0 && !Character.isDigit(c)){
                break;
            }
            if(c == '-'){
                sign = -1;
                count++;
            }else if(c == '+'){
                sign = 1;
                count++;
            }else if(Character.isDigit(c)){
                res = res * 10 + c - '0';
                if(res >= Integer.MAX_VALUE){
                    res = sign * res;
                    if(res >= Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                    if(res <= Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }
                count++;
            }
        }

        res = res * sign;

        return(int)res;


    }
}
