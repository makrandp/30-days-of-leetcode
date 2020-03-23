/**
 * Leetcode problem #448. Find All Numbers Disappeared in an Array
 * 
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length == 0) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> ans = new ArrayList<>();
        
        int n = nums.length;
        
        for(int i = 0; i < n; i++)
        {
            while(nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                ans.add(i+1);
            }
        }
        
        return ans;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}