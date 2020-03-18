/**
 * 153. Find Minimum in Rotated Sorted Array
 * 
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */

class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length == 0) {
            return -1;
        }
        
        int low = 0, high = nums.length - 1;
        while(low < high)
        {
            int mid = low + (high - low)/2;
            
            //find unsorted region
            if(nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return nums[low];
    }
}