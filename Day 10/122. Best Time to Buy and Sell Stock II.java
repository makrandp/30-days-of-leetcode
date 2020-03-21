/**
 * Leetcode problem #122. Best Time to Buy and Sell Stock II
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 */

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        
        int maxProfit = 0;
        
        for(int i = 1; i < prices.length; i++) 
        {
            //if current day price is greater than yesterday's price - sell it
            if(prices[i] > prices[i-1]) {
                int profit = prices[i] - prices[i-1];
                maxProfit += profit;
            }
        }
        return maxProfit;
    }
}