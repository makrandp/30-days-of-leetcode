/**
 * Leetcode problem #145. Binary Tree Postorder Traversal
 * 
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */

//Recursive Solution 
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        postorder(root, list);
        
        return list;
    }
    
    public void postorder(TreeNode root, LinkedList<Integer> list)
    {
        if(root == null) {
            return;
        }
        
        postorder(root.left, list);
        postorder(root.right, list);
        
        list.addLast(root.val);
    }
}


//Iterative Solution 
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        if(root == null) {
            return list;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        
        while(!stack.isEmpty()) 
        {
            TreeNode node = stack.pop();
            
            if(node != null) 
            {
                //adding everytime at the start of the list
                list.addFirst(node.val);
                
                //pushing left first - so it will be popped out last
                stack.push(node.left);
                
                //pushing right last - so it will be popped out first
                stack.push(node.right);   
            }
        }
        
        return list;
    }
    
}