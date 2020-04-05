/**
 * Leetcode problem #130. Surrounded Regions
 * 
 * https://leetcode.com/problems/surrounded-regions/
 * 
 */

class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        
        //boundary cells - mark all the cells - which cannot be flipped
        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            
            if(board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length-1);
            }
        }
        
        for(int j = 1; j < board[0].length; j++) {
            if(board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            
            if(board[board.length - 1][j] == 'O') {
                dfs(board, board.length - 1, j);
            }
        }
        
        //now flip 
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } 
                if(board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        } 
    }
    
    private void dfs(char[][] board, int i, int j)
    {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        
        if(board[i][j] != 'O') {
            return;
        }
        
        //else
        //mark the border cell so that we dont flip it
        board[i][j] = '1';
        //go through all the surrounding cells
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}