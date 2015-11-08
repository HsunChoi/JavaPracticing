package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cuixun on 5/26/15.
 */
public class Test {
    public static void main(String[]args){
        /**
         *

        String[] s = {"asd", null, "qwe"};
        System.out.println("asf".compareTo("sdf"));
        int[] b = {1, 2, 3, 4, 5};
        int[] a = new int[b.length];
        for(int i = 0; i < b.length; i++){
            a[i] = b[i];
        }
         //b[3] = 0;
         System.out.println(a == b);

         Xun.print(a);
         for(String q:s){
         System.out.println(q);
         }
         */
        String s1 = "123456789";
        int[] a1 = new int[s1.length()];
        for(int i = 0; i < s1.length(); i++){
            a1[i] = Integer.parseInt(s1.substring(i, i + 1));
         }
        Xun.print(a1);


        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        List<String> list = new ArrayList<String>();
        list.add("sad");
        list.add("nice");
        Xun.printString(list);
        System.out.println();
        list.clear();
        Xun.printString(list);
    }

}
