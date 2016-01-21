package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 1/17/16.
 *
 * test case -1, 824883294
 */
public class NumberOfDigitOne {

    public static void main(String[]args){
        System.out.println(countDigitOne(7821));
    }


    public static int countDigitOne(int n) {
        int[] numOfDigit = new int[n + 1];
        numOfDigit[0] = 0;
        numOfDigit[1] = 1;
        for(int i = 2; i <= n; i++){
            numOfDigit[i] = numOfDigit[i - 1] + countDigit(i);
        }

        return numOfDigit[n];

    }

    public static int countDigit(int num){
        int count = 0;
        /**
         if(num == 1){
         return 1;
         }
         */
        while(num != 0){
            if(num % 10 == 1){
                count++;
            }

            num /= 10;
        }
        return count;
    }
}
