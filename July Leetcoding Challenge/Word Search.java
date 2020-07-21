/**
 * July Leetcoding Challenge
 * 
 * Problem: Word Search
 */

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) {
            return false;
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(exists(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    
    private boolean exists(char[][] board, int i, int j, String word, int index) {
        if(index >= word.length()) {
            return true;
        }
        
        //boundary conditions
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        
        if(board[i][j] != word.charAt(index)) {
            return false;
        }
        
        //mark as visited
        board[i][j] = '#';
        
        //check in all 4 directions
        boolean found = exists(board, i + 1, j, word, index + 1) 
            || exists(board, i - 1, j, word, index + 1) 
            || exists(board, i, j + 1, word, index + 1) 
            || exists(board, i, j - 1, word, index + 1);
        
        //backtrack
        board[i][j] = word.charAt(index);
        
        return found;
    }
}