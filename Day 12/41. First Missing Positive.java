/**
 * Leetcode problem #41. First Missing Positive
 * 
 * https://leetcode.com/problems/first-missing-positive/
 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        if(nums.length == 0) {
            return 1;
        }
        
        int n = nums.length;
        
        for(int i = 0; i < n; ++i) {
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
    
        return n+1;
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}