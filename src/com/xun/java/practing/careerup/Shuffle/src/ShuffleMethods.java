package com.xun.java.practing.careerup.Shuffle.src;

import com.xun.java.practing.leetcode.Xun;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by cuixun on 3/31/15.
 */
public class ShuffleMethods {
    public static void main(String[]args){
        int[] a  = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> list = new ArrayList<Integer>();
        /**
         * shuffle an array
         */
        shuffle(a);
        System.out.println();
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }
        /**
         * shuffle a list
         */
        Xun.printInteger(list);
        shuffle(list);
        Xun.printInteger(list);
    }

    public static void shuffle(int[] a){
        int index;
        Random r = new Random();
        /**
         *We 3 times the length of the size; at least twice the size
         */
        for(int i= 0; i < 20; i++){
            index = r.nextInt(a.length);
            int tmp = a[index];
            a[index] = a[0];
            a[0] = tmp;
        }

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

    }

    public static void shuffle(ArrayList<Integer> list){
        int index;
        Random r = new Random();
        for(int i = 0; i <= 50; i++){
            index = r.nextInt(list.size());
            int tmp = list.get(index);
            list.set(index, list.get(0));
            list.set(0, tmp);
        }
    }


}
