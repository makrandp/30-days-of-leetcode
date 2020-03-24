/**
 * 
 * Leetcode problem #46. Permutations
 * 
 * https://leetcode.com/problems/permutations/
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) {
            return Collections.emptyList();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        generatePermutations(nums, new ArrayList<>(), result);
        
        return result;
    }
    
    private void generatePermutations(int[] nums, List<Integer> current, List<List<Integer>> result) 
    {
        if(nums.length == current.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(current.contains(nums[i])) {
                continue;
            }
            
            //add
            current.add(nums[i]);
            //recurse
            generatePermutations(nums, current, result);
            //remove(backtrack) - recently inserted element
            current.remove(current.size() - 1);     
        }
    }
    
    
}