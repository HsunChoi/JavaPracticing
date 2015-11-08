package com.xun.java.practing.leetcode;

import java.util.List;

/**
 * Created by cuixun on 5/4/15.
 */
public class LongCommonPrefix {
    public static void main(String[]args){

    }

    public static String findLongComPre(List<String> strs){
        StringBuffer str = new StringBuffer();
        if(strs.size() == 0){
            return "";
        }
        if(strs.size() == 1){
            return strs.get(0);
        }
        for(int i = 0; i < strs.get(0).length(); i++){
            char tmp = strs.get(0).charAt(i);
            for(String s:strs){
                if(s.length() <= i || s.charAt(i) != tmp){
                    return new String(str);
                }
            }
            str.append(tmp);
        }
        return new String(str);
    }

}
