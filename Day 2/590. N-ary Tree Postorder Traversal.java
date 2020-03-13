/**
 * Leetcode problem #590. N-ary Tree Postorder Traversal
 * 
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */

//Recursive solution 
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        postorderTraversal(root, list);
        
        return list;
    }
    
    public void postorderTraversal(Node root, LinkedList<Integer> list)
    {
        if(root == null) {
            return;
        }
        
        for(Node child : root.children) {
            postorderTraversal(child, list);
        }
        
        list.addLast(root.val);
    }
}


//Iterative solution 
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        if(root == null) {
            return list;
        }
        
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        
        while(!stack.isEmpty()) 
        {
            Node node = stack.pop();
            
            if(node != null) {
                list.addFirst(node.val);
                
                for(Node child : node.children) {
                    stack.push(child);
                }
            }
        }
        
        return list;
    }
}