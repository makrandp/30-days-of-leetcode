/**
 * Leetcode problem #121. Best Time to Buy and Sell Stock
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */


class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        
        int min = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++)
        {
            if(prices[i] < min) {
                min = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;
    }
}