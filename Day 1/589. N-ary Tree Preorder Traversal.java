/**
 * Leetcode problem #589. N-ary Tree Preorder Traversal
 * 
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */

//Recursive Solution
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        
        preorderTraversal(root, list);
        return list;
    }
    
    public void preorderTraversal(Node root, List<Integer> list)
    {
        if(root == null) {
            return;
        }
        
        list.add(root.val);
        
        for(Node child : root.children) {
            preorderTraversal(child, list);
        }
    }
}

//Iterative Solution
class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if(root == null) {
            return list;
        }
        
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            Node node = stack.pop();
            list.add(node.val);
            
            Collections.reverse(node.children);
            
            for(Node child : node.children)
            {
                if(child != null) {
                    stack.push(child);
                }
            }
        }
        return list;
    }
}