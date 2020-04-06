/**
 * Leetcode problem #286. Walls and Gates
 * 
 * https://leetcode.com/problems/walls-and-gates/
 */

class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0) {
            return;
        }
        
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[i].length; j++) {
                //check if its a gate
                if(rooms[i][j] == 0) {
                    //if gate found then add it to the queue
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        //now do BFS from each gate. BFS will find the shortest path
        while(!queue.isEmpty()) {
            int[] points = queue.remove();
            //travel the grid in 4 directions
            for(int[] direction : directions) {
                int row = points[0] + direction[0];
                int col = points[1] + direction[1];
                
                //check boundaries
                if(row < 0 || col < 0 || row >= rooms.length || col >= rooms[0].length) {
                    //check next direction
                    continue;
                }
                
                if(rooms[row][col] != Integer.MAX_VALUE) {
                    //check next cell
                    continue;
                }
                
                //add the distance from gate
                rooms[row][col] = rooms[points[0]][points[1]] + 1;
                queue.offer(new int[]{row, col});
            }  
        }
    }
}