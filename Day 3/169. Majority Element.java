/**
 * Leetcode problem #169. Majority Element
 * 
 * https://leetcode.com/problems/majority-element/
 */

//Using Hashmap
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int count = Integer.MIN_VALUE;
        int major = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > count) {
                major = entry.getKey();
                count = entry.getValue();
            }
        }
        
        return major;
    }
}

//Using sorting
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        
        return nums[nums.length/2];
    }
}

//Boyer-Moore Algorithm
//Refer: https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html 
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer major = null;
        
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                major = nums[i];
            }
            
            if(major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        
        return major;
    }
}