package com.xun.java.practing.leetcode;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by cuixun on 3/30/16.
 */
public class NthUglyNumber {
    public static void main(String[]args){
        int[] nums = getNunlyNumber(30);
        Xun.print(nums);
    }


    static int[] getNunlyNumber(int n){
        int[] nums = null;
        try {
            nums = new int[n];
            nums[0] = 1;
            int f2 = 2, f3 = 3, f5 = 5;
            int index2 = 0, index3 = 0, index5 = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 1; i < n; i++){
                min = Math.min(f2, Math.min(f3, f5));
                nums[i] = min;
                if(min == f2){
                    f2 = 2 * nums[++index2];
                }
                if(min == f3){
                    f3 = 3 * nums[++index3];
                }
                if(min == f5){
                    f5 = 5 * nums[++index5];
                }
            }


        }catch (NegativeArraySizeException e){
            System.out.println("Please enter the positive n: ");
//            Scanner cin = new Scanner(System.in);
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedInputStream inputStream = new BufferedInputStream(System.in);

            try {
                int nn = inputStream.read();
                getNunlyNumber(nn);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }



        return nums;
    }
}
