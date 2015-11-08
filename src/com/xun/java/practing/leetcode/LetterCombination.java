package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cuixun on 5/7/15.
 */
public class LetterCombination {
    static String[] phone = {"", "", "abc", "dei", "ghf", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        System.out.println("Please enter an digit: ");
        String digits = cin.nextLine();
        List<String> list = letterCombinations(digits);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println(list.size());
    }


    public static List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        list.add("");
        list = combinate(digits, list);
        return list;
    }

    public static List<String> combinate(String digits, List<String> list) {
        if (digits.length() == 0 || digits == "") {
            return list;
        }
        String tmp = phone[Integer.parseInt(digits.charAt(0) + "")];
        int listSize = list.size();
        List<String> nlist = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            String l = list.get(i);
            for (int j = 0; j < tmp.length(); j++) {
                char c = tmp.charAt(j);
                nlist.add(l + c + "");
            }
            /*if (tmp.length() > 0) {
                list.set(i, l + tmp.charAt(0) + "");
            }
            */
        }
        digits = digits.substring(1);
        return combinate(digits, nlist);
    }

}
