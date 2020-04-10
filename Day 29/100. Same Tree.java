/**
 * 100. Same Tree
 * 
 * https://leetcode.com/problems/same-tree/
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        
        if(p == null || q == null) {
            return false;
        }
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        stack1.push(p);
        stack2.push(q);
        
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            
            if(node1 == null && node2 == null) {
                continue;
            }
            
            if(node1 == null || node2 == null) {
                return false;
            }
            
            if(node1.val != node2.val) {
                return false;
            }
            
            stack1.push(node1.left);
            stack2.push(node2.left);
            
            stack1.push(node1.right);
            stack2.push(node2.right);
            
        }
        
        return true;
    }
}