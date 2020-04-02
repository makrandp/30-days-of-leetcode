/**
 * Leetcode problem #136. Single Number
 * 
 * https://leetcode.com/problems/single-number/
 */

class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }
        
        int ans = 0;
        for(int num : nums) {
            ans ^= num;
        }
        
        return ans;
    }
}