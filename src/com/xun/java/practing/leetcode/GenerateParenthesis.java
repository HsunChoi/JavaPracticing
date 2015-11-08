package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cuixun on 5/12/15.
 */
public class GenerateParenthesis {
    public static void main(String[]args){
        Scanner cin = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int n = cin.nextInt();
        List<String> list = generateParenthesis(n);
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

    public static List<String> generateParenthesis(int n){
        List<String> list = new ArrayList<String>();
        if(n <= 0){
            return list;
        }
        String s = "(";
        generateParenthesis(list, 2 * n - 1, s, 1);
        return list;
    }

    public static void generateParenthesis(List<String> list, int n, String s, int sum){
        if(n == 0 && sum == 0){
            list.add(s);
            return;
        }
        if(sum < 0){
            return;
        }
        if(n < 0){
            return;
        }
        generateParenthesis(list, n - 1, s + "(", sum + 1);
        generateParenthesis(list, n - 1, s + ")", sum - 1);

    }
}
