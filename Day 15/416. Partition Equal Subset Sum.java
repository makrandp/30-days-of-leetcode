/**
 * Problem #416. Partition Equal Subset Sum
 * 
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */


class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return true;
        }
        
        int sum = 0; 
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if(sum % 2 != 0) {
            return false;
        }
        
        boolean[][] solution = new boolean[nums.length + 1][sum/2 + 1];
        
        
        //first column
        for(int i = 0; i < solution.length; i++)
        {
            //can always form a sum 0 without including any element - empty subset
            solution[i][0] = true;
        }
        
        //first row 
        for(int i = 1 ; i < solution[0].length; i++) {
            //0 elements can't form a set of sum i
            solution[0][i] = false;
        }
        
        for(int i = 1; i < solution.length; i++)
        {
            for(int j = 1; j < solution[i].length; j++)
            {
                boolean option1 = false, option2 = false;
                //exclude element
                option1 = solution[i-1][j];
                
                //include element only if its less than the sum allowed
                if(nums[i - 1] <= j) {
                    //check if we can find a subset to get remaining sums
                    option2 = solution[i-1][j - nums[i-1]];
                }
                
                //use whichever is true
                solution[i][j] = option1 || option2;
            }
        }
    
        return solution[nums.length][sum/2];
        
    }
}