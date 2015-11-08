package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 6/19/15.
 */
public class SetZeros {
    public static void main(String[] args) {
        int[][] a = {{2, 3, 6, 2, 7, 5, 2, 6, 9, 4}, {5, 3, 9, 3, 0, 3, 5, 7, 7, 0}
                , {0, 9, 9, 1, 4, 4, 6, 3, 2, 5}, {5, 6, 1, 1, 9, 0, 6, 1, 6, 7}
                , {7, 4, 2, 6, 7, 3, 1, 5, 2, 8}, {5, 2, 0, 6, 6, 4, 0, 4, 9, 2}
                , {9, 4, 1, 2, 6, 0, 3, 4, 3, 9}, {4, 2, 5, 6, 8, 5, 9, 2, 0, 4}};

        Xun.printMatrix(a);
        setZeroes(a);
        Xun.printMatrix(a);

    }

    public static void setZeroes(int[][] matrix) {
        boolean fr = false, fc = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (fr) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (fc) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
