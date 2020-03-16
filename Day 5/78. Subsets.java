/**
 * Leetcode problem #78. Subsets
 * 
 * https://leetcode.com/problems/subsets/
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(new LinkedList<>());
        
        for(int num : nums)
        {
            int size = ans.size();
            for(int i = 0; i < size; i++)
            {
                //copy the existing list
                List<Integer> list = new LinkedList<>(ans.get(i));
                //add the current item
                list.add(num);
                ans.add(list);
            }
        }
        
        return ans;
    }
}