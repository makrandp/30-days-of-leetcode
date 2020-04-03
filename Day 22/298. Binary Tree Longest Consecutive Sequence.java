/**
 * Leetcode problem #298. Binary Tree Longest Consecutive Sequence
 * 
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 */

class Solution {
    public int longestConsecutive(TreeNode root) {
        int[] max = new int[1];
        
        longestConsecutiveSequence(root, 0, 0, max);
        
        return max[0];
    }
    
    //preorder traversal
    private void longestConsecutiveSequence(TreeNode root, int count, int target, int[] max) {
        if(root == null) {
            return;
        } else if(root.val == target) {
            count++;
        } else {
            count = 1;
        }
        
        max[0] = Math.max(max[0], count);
        
        longestConsecutiveSequence(root.left, count, root.val + 1, max);
        longestConsecutiveSequence(root.right, count, root.val + 1, max);
    }
}