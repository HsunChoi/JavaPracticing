package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuixun on 7/14/15.
 */
public class NQueens {
    public static void main(String[]args){
        int n = 8;
        List<List<Integer>> queens = nQueens(n);
        Xun.printList(queens);
        System.out.println(queens.size());
        for(List<Integer> list : queens){
            printAsMatrix(list);
        }
    }

    static List<List<Integer>> nQueens(int n){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        placeQueens(n, 0, lists, list);
        boolean[][] x = new boolean[1][1];
        return lists;
    }

    static void placeQueens(int n, int row, List<List<Integer>> lists, List<Integer> list){
        if(row == n){
            /**
             * no need if here
             */
            if(!lists.contains(list)) {
                lists.add(list);
            }
            return;
        }
        for(int i = 0; i < n; i++){
            if(isSafe(row, i, list)){
                List<Integer> nlist = new ArrayList<>(list);
                nlist.add(i);
                placeQueens(n, row + 1, lists, nlist);
            }
        }
        return;
    }

    static boolean isSafe(int row, int col, List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            if(row == i || col == list.get(i) || Math.abs(row - i) == Math.abs(col - list.get(i))){
                return false;
            }
        }
        return true;
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
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
