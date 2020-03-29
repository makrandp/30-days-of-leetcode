/**
 * Leetcode problem #494. Target Sum
 * 
 * https://leetcode.com/problems/target-sum/
 */

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0) {
            return 0;
        }
        
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        
        if(totalSum < S || (S + totalSum) % 2 != 0 ) {
            return 0;
        }
        
        int sum = (S + totalSum) / 2;
        
        int[] dp = new int[sum+1];
        
        dp[0] = 1;
        
        for(int num : nums) {
            for(int j = sum; j >= 0; j--) {
                if(num <= j) 
                {
                    dp[j] = dp[j] + dp[j - num];
                }
            }
        }
        
        return dp[sum];
    }
}