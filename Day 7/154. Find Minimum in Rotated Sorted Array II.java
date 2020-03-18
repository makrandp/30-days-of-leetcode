/**
 * 154. Find Minimum in Rotated Sorted Array II
 * 
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
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
            if(nums[mid] < nums[high]) {
                //go to unsorted region
                high = mid;
            } else if(nums[mid] > nums[high]) {
                //go to the unsorted region
                low = mid + 1;
            } else {
                high--;
            }
            
        }
        return nums[low];
    }
}