package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 3/28/15.
 */
public class PalindromeInt {
    public static void main(String[]args){
        System.out.println(isPalindromeInt(2332));
    }

    public static boolean isPalindromeInt(int x){
        if(x < 0){
            x = -x;
        }
        int reverse = 0;
        int tmp = x;
        while(tmp != 0){
            reverse = reverse * 10 + tmp % 10;
            tmp /= 10;
        }
        //reverse = reverse * 10 + tmp;

        return reverse == x;

    }
}
