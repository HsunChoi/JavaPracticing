package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 5/23/15.
 * Wrong answers here
 */
public class DivideWithoutDivision {
    public static void main(String[]args){
        System.out.print(divide(6, 2));
        int x = -9;

    }

    public static int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }

        if(dividend == divisor){
            return 1;
        }
        return divide(dividend - divisor, divisor) + 1;
    }
}
