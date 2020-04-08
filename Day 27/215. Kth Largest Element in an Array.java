/**
 * 215. Kth Largest Element in an Array
 * 
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */


class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        //kth largest = (n-k) smallest - IMP
        return findKthLargestElement(nums, (nums.length-k), 0, nums.length - 1);
    }
    
    private int findKthLargestElement(int[] nums, int k, int start, int end) {
        //find pivot
        int pivot = partition(nums, start, end);
        
        if(pivot == k) {
            return nums[pivot];
        } 
        
        //if index of pivot is greater than k's index
        if(pivot > k) {
            //search on the left side
            return findKthLargestElement(nums, k, start, pivot-1);
        } 
        
        //else
       //search on the right side
        return findKthLargestElement(nums, k, pivot+1, end);  
    }
    
    
    private int partition(int[] nums, int low, int high) {
        if(low >= high) {
            return low;
        }
        
        //get randomized pivot index 
        Random random = new Random();
        int pivotIndex = low + random.nextInt(high - low); 
        
        //always move pivot to end
        swap(nums, pivotIndex, high);
        
        int pivot = nums[high];
        
        //loop through array from low to high
        for(int i = low; i < high; i++) {
            //if nums[i] < pivot
            if(nums[i] < pivot) {
                //move all the elements behind low
                swap(nums, i, low);
                low++;
            }
        }
        
        //swap pivot and low, so that all the elements left of pivot are smaller 
        // and all the elements on the right of pivot arr greater
        swap(nums, low, high);
      
        return low;
    }
    
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}