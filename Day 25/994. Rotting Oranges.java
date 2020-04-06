/**
 * Leetcode problem 994. Rotting Oranges
 * 
 * https://leetcode.com/problems/rotting-oranges/
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                //check if cell contains rotten orange
                if(grid[i][j] == 2) {
                    //add the rotten orange to queue
                    queue.offer(new int[]{i, j});
                } 
                else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        //if no fresh oranges found
        if(freshOranges == 0) {
            return 0;
        }
        
        //4 directions
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        
        //count the minutes needed to rotten the oranges
        int minutes = 0; //IMP
        
        //do bfs
        while(!queue.isEmpty()) {
            
            //Rotten oranges simultaneously affect adjacent fresh oranges.
            int currentQueueSize = queue.size();
            for(int i = 0; i < currentQueueSize; i++) {
                int[] currentCell = queue.remove();
            
                //traverse the grid in all 4 directions
                for(int[] direction : directions) {
                    int row = currentCell[0] + direction[0];
                    int col = currentCell[1] + direction[1];

                    //check boundaries
                    if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
                        //move to next direction
                        continue;
                    }

                    if(grid[row][col] != 1) {
                        continue;
                    }

                    //convert fresh orange to rotten 
                    if(grid[row][col] == 1) {
                        grid[row][col] = 2;
                        queue.offer(new int[]{row, col});
                        freshOranges--;
                    }
                }
            }
            
            //minutes change once all the fresh oranges next to currently rotten oranges(queue elements) gets converted to rotten - as it happens simultenously
            minutes++;
        }
        
        return freshOranges == 0 ? minutes - 1 : -1;
    }
}