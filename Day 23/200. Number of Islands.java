/**
 * Leetcode problem #200. Number of Islands
 * 
 * https://leetcode.com/problems/number-of-islands/
 */


class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        int numOfIslands = 0;
        
        //loop through the grid
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                //if land found
                if(grid[i][j] == '1') {
                    //shrink the neighbouring lands into one
                    dfs(grid, i, j);
                    numOfIslands++;
                }
            }
        }
        
        return numOfIslands;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        //check bounds
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        
        //return if no land found
        if(grid[i][j] != '1') {
            return;
        }
        
        //else
        //shrink the lands
        grid[i][j] = '0';
        //go in 4 directions of a grid
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}