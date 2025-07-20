package Recursion.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static List<List<String>> NQueens(int n){
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack6(result, board, 0, n);
        return result;
    }

    private static void backtrack6(List<List<String>> result, char[][] board, int row, int n){

    }

    private boolean isSafe(char[][] board, int col, int row, int n){
        for (int i = 0; i < row; i++){
            if(board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
