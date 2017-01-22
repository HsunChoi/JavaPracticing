package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuixun on 7/14/15.
 */
public class NQueens {
    public static void main(String[]args){
        int n = 8;
        List<List<String>> queens = solveNQueens(n);
        Xun.printStringMatrix(queens);
    }

    public static List<List<String>> solveNQueens(int n) {

        List<Integer> list = new LinkedList<>();
        List<List<Integer>> lists = new LinkedList<>();
        int row = 0;
        getNQueensLists(lists, list, n);

        List<List<String>> resLists = convertLists(lists, n);
        return resLists;

    }



    static void getNQueensLists(List<List<Integer>> lists, List<Integer> list, int n){
        if(list.size() > n){
            return;
        }
        if(list.size() == n){
            lists.add(list);
            return;
        }
        for(int i = 0; i < n; i++){
            if(isValid(list, i)){
                List<Integer> nList = new LinkedList(list);
                nList.add(i);
                getNQueensLists(lists, nList, n);
            }
        }

    }

    static boolean isValid(List<Integer> list, int col){
        int row = list.size();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == col || Math.abs(list.get(i) - col) == Math.abs(row - i)){
                return false;
            }
        }
        return true;
    }

    static List<List<String>> convertLists(List<List<Integer>> lists, int n){
        List<List<String>> slists = new LinkedList<>();
        for(List<Integer> list : lists){
            List<String> slist = new LinkedList<String>();
            for(Integer i : list){
                StringBuilder sb = new StringBuilder();
                for(int index = 0; index < n; index++){
                    if(index != i){
                        sb.append(".");
                    }else{
                        sb.append("Q");
                    }
                }
                slist.add(sb.toString());
            }
            slists.add(slist);
        }
        return slists;
    }

    static void printAsMatrix(List<Integer> list){
        for(int row = 0; row < list.size(); row++){
            int position = list.get(row);
            for(int col = 0; col < list.size(); col++){
                if(col == position){
                    System.out.print("Q ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }
}
