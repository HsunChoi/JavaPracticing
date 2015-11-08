package com.xun.java.practing.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cuixun on 6/12/15.
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Map<Character, Character> mapS = new HashMap<Character, Character>();
        Map<Character, Character> mapT = new HashMap<Character, Character>();
        for(int i = 0; i < s1.length; i++){
            if(!mapT.containsKey(s.charAt(i))){
                mapT.put(s.charAt(i), t.charAt(i));
            }
            s1[i] = mapT.get(s.charAt(i));

            if(!mapS.containsKey(t.charAt(i))){
                mapS.put(t.charAt(i), s.charAt(i));
            }
            t1[i] = mapS.get(t.charAt(i));
        }
        String ss = new String(s1);
        String tt = new String(t1);
        if(s.equals(tt) && t.equals(ss)){
            return true;
        }
        return false;
    }
}
