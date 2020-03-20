/**
 * Leetcode problem #238. Product of Array Except Self
 * 
 * https://leetcode.com/problems/product-of-array-except-self/
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) {
            return nums;
        }
        
        int[] l = new int[nums.length];
        
        int left = 1;
        for(int i = 0; i < nums.length; i++) {
            l[i] = left; 
            left *= nums[i];
        }
        
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            l[i] *= right;
            right *= nums[i];
        }
        
        return l;
  }
}