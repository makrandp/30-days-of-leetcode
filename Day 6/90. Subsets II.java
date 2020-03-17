/**
 * Leetcode problem #90. Subsets II
 * 
 * https://leetcode.com/problems/subsets-ii/
 */

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        
        ans.add(new LinkedList<>());
        
        //sort the input
        Arrays.sort(nums);
        int startIndex = 0;
        int endIndex = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            startIndex = 0;
            
            //if duplicate found
            if(i > 0 && nums[i] == nums[i-1]) {
                //update startIndex
            // create new subsets only from the subsets which are added in the previous step
                //dont start from zero index
                startIndex = endIndex;
            }
            
            endIndex = ans.size();
            
            for(int j = startIndex; j < endIndex; j++) {
                // create a new subset from the existing subset
                List<Integer> list = new LinkedList<>(ans.get(j));
                //add the current element to it
                list.add(nums[i]);
                ans.add(list);
            }
        }
        return ans;
    }
}