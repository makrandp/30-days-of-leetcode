/**
 * Leetcode problem #268. Missing Number
 * 
 * https://leetcode.com/problems/missing-number/
 */

class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        for(int i = 0; i < n; i++) 
        {
            while(nums[i] < n && nums[nums[i]] != nums[i]) {
                swap(nums, nums[i], i);
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            if(nums[i] != i) {
                return i;
            }
        }
        
        return n;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}