package com.xun.java.practing.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuixun on 3/24/15.
 */
public class DistinctChars {
    public static void main(String[]args){
        String s = "aaaaaaaaaaaaaaaaaeeeeeeeeeeeeeeeeccccccccccccccc";
        int x = caculDistinctChar(s);
        System.out.println(x);
    }

    public static int caculDistinctChar(String s){
        int num = 0;
        List<Integer> list =new LinkedList<Integer>();
        for(int i = 0; i < s.length(); i++){
            int x = s.charAt(i);
            if(!list.contains(x)){
                list.add(x);
            }
        }
        num = list.size();
        return num;
    }
}
