package com.xun.java.practing.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuixun on 3/23/15.
 * Write a function to find all the 10-letter-long sequences (substrings)
 * that occur more than once in a DNA molecule
 */
public class FindReaptedSubstrings {
    public static void main(String[]args){
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String d = "CTCCACTGCTTATAATCCACCAAGTCCAGACTCAAAGCTCAACCATCCTTATGCCAGATTATTAGTTCATTGAATGTCGGTCGCCGGCGCTCCCGCATTTCTTATCCGCGTA";
        //System.out.println(d.substring(0, 3));
        //System.out.println(d.equals(s));
        List<String> list = finRepeatedSubstring(s);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

    public static List<String> finRepeatedSubstring(String s){
        if (s.length() < 10){
            return null;
        }
        List<String> list = new LinkedList<String>();
        List<String> repeatList = new LinkedList<String>();
        for(int i = 0; i + 10 <= s.length(); i++){
            String subS = s.substring(i, i + 10);
            if(!list.contains(subS)){
                list.add(subS);
            }else{
                repeatList.add(subS);
            }
        }

        return repeatList;
    }
}