package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 7/1/15.
 */
public class SurroundRegion {

    public static void main(String[]args){
        String s = "OOOOOOOOOXXXXXXXXXXXXXXXOOOOOOOXOXOXOOXOXOXOXOXOXOXOXOXOXOXOXOXOXOXOXOXO";
        char[][] a = {s.toCharArray(), s.toCharArray(), s.toCharArray(), s.toCharArray(), s.toCharArray(), s.toCharArray(), s.toCharArray()};
        solve(a);
        Xun.printMatrix(a);
    }

    public static void solve(char[][] board) {
        if(board.length == 0){
            return;
        }
        boolean[][] buffer = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    if(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1){
                        buffer[i][j] = true;
                    }
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O' && noO(buffer, i, j)){
                    isSurround(board, i, j);
                }
            }
        }

    }

    static boolean isSurround(char[][] a, int i, int j){
        if(i < 0 || j < 0 || i >= a.length || j >= a[0].length){
            return false;
        }
        if(hasO(a, i, j)){
            return false;
        }
        return true;
    }

    static boolean hasO(char[][] a, int i, int j){
        if(i < 0 || j < 0 || i >= a.length || j >= a[0].length){
            return true;
        }
        if(a[i][j] == 'X') {
            return false;
        }
        a[i][j] = 'X';
        if(hasO(a, i - 1, j) || hasO(a, i + 1, j) || hasO(a, i, j - 1) || hasO(a, i, j + 1)){
            a[i][j] = 'O';
            return true;
        }

        return false;
    }

    static boolean noO(boolean[][] buffer, int i, int j){
        if(i == 0 || j == 0 || i == buffer.length - 1 || j == buffer[0].length - 1){
            return false;
        }
        if(buffer[i - 1][j] == true || buffer[i + 1][j] == true || buffer[i][j - 1] == true || buffer[i][j + 1] == true){
            buffer[i][j] = true;
            return false;
        }
        return true;
    }

    /**
     * Method 2, which will not cause stack over flow error
     * @param board
     */
    public static void solve2(char[][] board) {
        if(board.length == 0){
            return;
        }
        boolean changed = true;
        while(changed){
            changed = false;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == 'O'){
                        if(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1
                                || board[i-1][j] == '1' || board[i+1][j] == '1' ||
                                board[i][j-1] == '1' || board[i][j+1] == '1'){
                            board[i][j] = '1';
                            changed = true;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }
}
