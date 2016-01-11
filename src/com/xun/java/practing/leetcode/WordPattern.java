package com.xun.java.practing.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cuixun on 12/18/15.
 */
public class WordPattern {
    public static void main(String[]args){
        String pattern = "abba";
        String str = "dog cat cat fish";
        System.out.println(wordPattern(pattern, str));

    }

    public static boolean wordPattern(String pattern, String str) {
        Map<String, Character> map = new HashMap<String, Character>();
        String[] arr = str.split(" ");
        if(arr.length != pattern.length()){
            return false;
        }
        for(int i = 0; i < arr.length; i++){
            char c = pattern.charAt(i);
            String s = arr[i];
            if(map.containsKey(s)){
                char tmp = map.get(s);
                if(tmp != c){
                    return false;
                }
            }else if(map.containsValue(c)){
                return false;
            }else{
                map.put(s, c);
            }
        }

        return true;
    }
}
