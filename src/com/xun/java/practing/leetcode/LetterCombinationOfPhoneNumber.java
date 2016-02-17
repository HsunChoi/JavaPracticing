package com.xun.java.practing.leetcode;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuixun on 8/3/15.
 */
public class LetterCombinationOfPhoneNumber {

    public static void main(String[]args){
String num = "1641";
        List<String> list = letterCombinations(num);
        List<String> list1 = letterCombinations1(num);

        Xun.printString(list);
        Xun.printString(list1);
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

    public static List<String> letterCombinations1(String digits) {
        String[] nums = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<String>();
        if(digits == null || digits.length() == 0){
            return list;
        }
        //list.add("");
        for(int i = 0; i < digits.length(); i++){
            int digit = digits.charAt(i) - '0';
            List<String> curList = new ArrayList<String>();
            char[] tmp = nums[digit].toCharArray();
            for(String s : list){
                for(char c : tmp){
                    curList.add(s + c);
                }
            }
            list = curList;
        }
        return list;
    }
}
