package com.xun.java.practing.leetcode;

import java.util.HashSet;

/**
 * Created by cuixun on 2/15/16.
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

 Link: https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
    public static void main(String[]args){

    }

    /**
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][]board){
        if(board == null || board.length != 9 || board[0].length != 9){
            return false;
        }
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] cell = new HashSet[9];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                char c = board[i][j];
                if(board[i][j] != '.'){
                    /**
                     * 012
                     * 345
                     * 678
                     * 012345678
                     * 0
                     * 1
                     * 2
                     * 3
                     * 4
                     * 5
                     * 6
                     * 7
                     * 8
                     * 3 * (row / 3) + col / 3
                     */
                    if(rows[i].add(c) && col[j].add(c) && cell[3 * (i / 3) + j / 3].add(c)){

                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
