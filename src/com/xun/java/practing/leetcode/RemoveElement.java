package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 5/23/15.
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p/>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public static void main(String[]args){
        int[]a = {1, 2, 2, 3, 4, 5, 6, 7, 8, 4, 5, 45, 9};
        Xun.print(a, removeElement(a, 2));
    }

    public static int removeElement(int[] a, int val){
        int pointer = 0;
        int x = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] != val){
                a[pointer] = a[i];
                pointer++;
            }else{
                x++;
            }
        }
        return a.length - x;
    }
}
