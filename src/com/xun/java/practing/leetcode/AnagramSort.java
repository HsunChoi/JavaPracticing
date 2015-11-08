package com.xun.java.practing.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by cuixun on 4/21/15.
 */
public class AnagramSort {
    public static void main(String[]args){
        String[] s = {"asdf", "adfrtgw", "have", "aveh", "veah", "ave"};
        anagramSort(s);

        for(String s1 : s){
            System.out.print(s1 + " ");
        }
    }

    static void anagramSort(String[] s){
        Comparator<String> anagComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(sort(o1) == sort(o2)) {
                    return 0;
                }
                if(o1.length()< o2.length()){
                    return -1;
                }
                return 1;
            }
            String sort(String s){
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            }
        };

        Arrays.sort(s, anagComparator);
    }
}
