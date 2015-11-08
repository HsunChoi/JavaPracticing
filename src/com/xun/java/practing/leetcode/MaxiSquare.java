package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 7/17/15.
 */
public class MaxiSquare {
    public static void main(String[]args){

    }

    static int maxSquare(char[][] m){
        if(m == null || m.length == 0){
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int max = 0;
        int[][]a = new int[row + 1][ col + 1];
        for(int i = 1; i < a.length; i++){
            for(int j = 1; j < a[0].length; j++){
                if(m[i - 1][j - 1] == '1'){
                    a[i][j] = Math.min(a[i - 1][j - 1], Math.min(a[i][j - 1], a[i - 1][j]));
                    max = Math.max(max, a[i][j]);
                }
            }
        }

        return max * max;
    }
}
