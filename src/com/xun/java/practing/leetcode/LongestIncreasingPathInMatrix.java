package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 1/22/16.
 */
public class LongestIncreasingPathInMatrix {
    public static void main(String[]args){

        int[][] matrix = {{0,1,2,3,4,5,6,7,8,9},
                {19,18,17,16,15,14,13,12,11,10},
                {20,21,22,23,24,25,26,27,28,29},
                {39,38,37,36,35,34,33,32,31,30},

                {40,41,42,43,44,45,46,47,48,49},

                {59,58,57,56,55,54,53,52,51,50},
                {60,61,62,63,64,65,66,67,68,69},
                {79,78,77,76,75,74,73,72,71,70},
                {80,81,82,83,84,85,86,87,88,89},
                {99,98,97,96,95,94,93,92,91,90},

                {100,101,102,103,104,105,106,107,108,109},
                {119,118,117,116,115,114,113,112,111,110},

                {120,121,122,123,124,125,126,127,128,129},
                {139,138,137,136,135,134,133,132,131,130},
                {0,0,0,0,0,0,0,0,0,0}};

        long x = System.nanoTime();
        System.out.println(longestIncreasingPathWithCheck(matrix));
        long y = System.nanoTime();
        System.out.println((y - x) / 1000 + "\n\n");

        long x1 = System.nanoTime();
        System.out.println(longestIncreasingPathWithoutCheck((matrix)));
        long y1 = System.nanoTime();
        System.out.println((y1 - x1) / 1000);

    }


    public static int longestIncreasingPathWithoutCheck(int[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int max = 0;
        //boolean[][] checkBox= new boolean[matrix.length][matrix[0].length];
        int[][] cache = new int[matrix.length][matrix[0].length];


        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                //int length = getLongestIncreasingPath(matrix, row, col, Integer.MIN_VALUE, checkBox, cache);
                int length = getLongestIncreasingPathWithoutCheck(matrix, row, col, Integer.MIN_VALUE, cache);
                max = Math.max(length, max);
            }
        }
        return max;
    }

    public static int getLongestIncreasingPathWithoutCheck(int[][] matrix, int row, int col, int pre,
                                                int[][] cache){


        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length
                || matrix[row][col] <= pre){
            return 0;
        }
        if(cache[row][col] > 0){
            return cache[row][col];
        }

        int tmp = matrix[row][col];

        int length1 = 0, length2 = 0, length3 = 0, length4 = 0;
        if(row + 1 < matrix.length  && matrix[row + 1][col] > tmp){
            length1 = getLongestIncreasingPathWithoutCheck(matrix, row + 1, col, tmp, cache);

        }
        if(row - 1 >= 0  && matrix[row - 1][col] > tmp){
            length2 = getLongestIncreasingPathWithoutCheck(matrix, row - 1, col, tmp, cache);
        }
        if(col - 1 >= 0 && matrix[row][col - 1] > tmp){
            length3 = getLongestIncreasingPathWithoutCheck(matrix, row, col - 1, tmp, cache);
        }
        if(col + 1 < matrix[0].length &&  matrix[row][col + 1] > tmp){
            length4 = getLongestIncreasingPathWithoutCheck(matrix, row, col + 1, tmp, cache);
        }

        int x = Math.max(length1, length2);
        int y = Math.max(length3, length4);
        cache[row][col] = Math.max(x, y) + 1;

        return cache[row][col];
    }



    public static int longestIncreasingPathWithCheck(int[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int max = 0;
        boolean[][] checkBox= new boolean[matrix.length][matrix[0].length];
        int[][] cache = new int[matrix.length][matrix[0].length];


        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                int length = getLongestIncreasingPath(matrix, row, col, Integer.MIN_VALUE, checkBox, cache);
                //int length = getLongestIncreasingPathWithoutCheck(matrix, row, col, Integer.MIN_VALUE, cache);
                max = Math.max(length, max);
            }
        }
        return max;
    }

    public static int getLongestIncreasingPath(int[][] matrix, int row, int col, int pre,
                                               boolean[][] checkBox, int[][] cache){


        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length
                || matrix[row][col] <= pre){
            return 0;
        }
        if(cache[row][col] > 0){
            return cache[row][col];
        }

        int tmp = matrix[row][col];
        checkBox[row][col] = true;
        int length1 = 0, length2 = 0, length3 = 0, length4 = 0;
        if(row + 1 < matrix.length && checkBox[row + 1][col] == false && matrix[row + 1][col] > tmp){
            length1 = getLongestIncreasingPath(matrix, row + 1, col, tmp, checkBox, cache);
            checkBox[row + 1][col] = false;
        }
        if(row - 1 >= 0 && checkBox[row - 1][col] == false && matrix[row - 1][col] > tmp){
            length2 = getLongestIncreasingPath(matrix, row - 1, col, tmp, checkBox, cache);
            checkBox[row - 1][col] = false;
        }
        if(col - 1 >= 0 && checkBox[row][col - 1] == false && matrix[row][col - 1] > tmp){
            length3 = getLongestIncreasingPath(matrix, row, col - 1, tmp, checkBox, cache);
            checkBox[row][col - 1] = false;
        }
        if(col + 1 < matrix[0].length && checkBox[row][col + 1] == false && matrix[row][col + 1] > tmp){
            length4 = getLongestIncreasingPath(matrix, row, col + 1, tmp, checkBox, cache);
            checkBox[row][col + 1] = false;
        }

        int x = Math.max(length1, length2);
        int y = Math.max(length3, length4);

        cache[row][col] = Math.max(x, y) + 1;
        checkBox[row][col] = false;

        return cache[row][col];
    }


    /**
     *
     * @param matrix
     * @return
     */
    public static int longestIncreasingPath1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int length = findSmallAround(i, j, matrix, cache, Integer.MAX_VALUE);
                max = Math.max(length, max);
            }
        }
        return max;
    }
    private static int findSmallAround(int i, int j, int[][] matrix, int[][] cache, int pre) {
        // if out of bond OR current cell value larger than previous cell value.
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] >= pre) {
            return 0;
        }
        // if calculated before, no need to do it again
        if (cache[i][j] > 0) {
            return cache[i][j];
        } else {
            int cur = matrix[i][j];
            int tempMax = 0;
            tempMax = Math.max(findSmallAround(i - 1, j, matrix, cache, cur), tempMax);
            tempMax = Math.max(findSmallAround(i + 1, j, matrix, cache, cur), tempMax);
            tempMax = Math.max(findSmallAround(i, j - 1, matrix, cache, cur), tempMax);
            tempMax = Math.max(findSmallAround(i, j + 1, matrix, cache, cur), tempMax);
            cache[i][j] = ++tempMax;
            return tempMax;
        }
    }
}
