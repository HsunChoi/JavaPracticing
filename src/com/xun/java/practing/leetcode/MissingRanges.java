package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuixun on 4/24/15.
 */
public class MissingRanges {
    public static void main(String[]args){

        int[] array = {4, 5, 23, 24, 25, 26, 27, 35, 45, 55, 65, 75};
        List<Integer> list = missingRanges(array);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

    public static List<Integer> missingRanges(int[] array){
        List<Integer> list = new ArrayList<Integer>();
        if(array[0] != 0){
            missingRanges(list, -1, array[0]);
        }
        for(int i = 0; i < array.length - 1; i++){
            if(array[i + 1] - array[i] != 1 && array[i + 1] < 99){
                missingRanges(list, array[i], array[i + 1]);
            }
        }
        if(array[array.length - 1] < 99){
            missingRanges(list, array[array.length - 1], 100);
        }

        return list;
    }

    public static void missingRanges(List<Integer> list, int start, int end){
        for(int i = start + 1; i < end; i++){
            list.add(i);
        }
    }
}
