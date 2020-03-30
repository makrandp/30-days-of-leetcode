/**
 * Leetcode problem #518. Coin Change 2
 * 
 * https://leetcode.com/problems/coin-change-2/
 */

class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0) {
            return 1;
        }
        
        if(coins.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        //first row 
        for(int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        
        //first column
        for(int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                
                dp[i][j] = dp[i-1][j];
                
                if(coins[i-1] <= j) {
                    dp[i][j] += dp[i][j - coins[i-1]];
                } 
            }
        }
        
        return dp[coins.length][amount];
    }
}