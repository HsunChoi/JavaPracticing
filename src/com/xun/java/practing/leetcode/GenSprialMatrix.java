package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 6/15/15.
 */
public class GenSprialMatrix {
    public static void main(String[]args){
        int a = 2;
        int[][] m = generateMatrix(a);
        Xun.printMatrix(m);
    }

    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        if(n > 0){
            generateNums(nums, 1, 0, nums.length, 0, nums[0].length);
        }
        return nums;
    }

    static void generateNums(int[][] nums,int start, int row, int loopX, int col, int loopY){
        if (row > (nums.length / 2) && col >= (nums[0].length / 2)) {
            return;
        }
        if(loopX <= 0 && loopY <= 0){
            return;
        }
        for(int i = col; i < col + loopY; i++){
            nums[row][i] = start;
            start++;
        }
        for(int i = row + 1; i < row + loopX; i++){
            nums[i][col + loopY - 1] = start;
            start++;
        }
        if(row + loopX - 1 > row){
            for(int i = col + loopY - 2; i >= col; i--){
                nums[row + loopX - 1][i] = start;
                start++;
            }
        }
        if(col < col + loopY - 1){
            for(int i = row + loopX - 2; i > row; i--){
                nums[i][col] = start;
                start++;
            }
        }
        generateNums(nums, start, row + 1, loopX - 2, col + 1, loopY - 2);
        return;

    }

}
