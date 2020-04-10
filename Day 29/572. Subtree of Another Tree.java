/**
 * 572. Subtree of Another Tree
 * 
 * https://leetcode.com/problems/subtree-of-another-tree/
 */

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }
        
        if(isSameTree(s, t)) {
            return true;
        }
        
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        
        if(p == null || q == null) {
            return false;
        }
        
        if(p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}