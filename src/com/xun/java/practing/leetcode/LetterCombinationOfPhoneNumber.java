package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuixun on 8/3/15.
 */
public class LetterCombinationOfPhoneNumber {

    public static void main(String[]args){

        List<String> list = letterCombinations("641");

        Xun.printString(list);
    }

    /**
     *
     * @param digits
     * @return
     */
    public  static List<String> letterCombinations(String digits) {
        String[] pool = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<String>();
        if(digits == null || digits.length() == 0){
            return list;
        }
        list.add("");


        for(int i = 0; i < digits.length(); i++){
            String letters = pool[Integer.parseInt(String.valueOf(digits.charAt(i)))];
            List<String> cur = new ArrayList<String>();
            for(int j = 0; j < letters.length(); j++){
                char c = letters.charAt(j);
                for(String s : list){
                    s = s + c;
                    cur.add(s);
                }

            }
            /**
             * I think this should be the right code
             * */
            if(!cur.isEmpty()) {
                list = cur;
            }


            //list = cur;
        }

        return list;
    }
}
