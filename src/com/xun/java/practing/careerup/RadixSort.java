package com.xun.java.practing.careerup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by cuixun on 10/26/15.
 */
public class RadixSort {
    private static final int BITS_PER_BYTE = 8;
    public static void main(String[]args){

        /**
         * you can set your own input here
         */
        Scanner cin = new Scanner(System.in);
        int[] nums = {12, -12, 32, 45, 123, 452, 2, -5346, 23, 32, 99, 100};
        sort(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i] + " ");
        }

    }

    public static void sort(int[] a) {
        int BITS = 32;                 // each int is 32 bits
        int W = BITS / BITS_PER_BYTE;  // each int is 4 bytes
        int R = 1 << BITS_PER_BYTE;    // each bytes is between 0 and 255
        int MASK = R - 1;              // 0xFF

        int N = a.length;
        int[] aux = new int[N];

        for (int d = 0; d < W; d++) {

            // compute frequency counts
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) {
                int c = (a[i] >> BITS_PER_BYTE*d) & MASK;
                count[c + 1]++;
            }

            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            // for most significant byte, 0x80-0xFF comes before 0x00-0x7F
            if (d == W-1) {
                int shift1 = count[R] - count[R/2];
                int shift2 = count[R/2];
                for (int r = 0; r < R/2; r++)
                    count[r] += shift1;
                for (int r = R/2; r < R; r++)
                    count[r] -= shift2;
            }

            // move data
            for (int i = 0; i < N; i++) {
                int c = (a[i] >> BITS_PER_BYTE*d) & MASK;
                aux[count[c]++] = a[i];
            }

            // copy back
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
}
