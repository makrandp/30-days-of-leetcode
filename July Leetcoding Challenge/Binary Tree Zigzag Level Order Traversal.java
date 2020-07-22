/**
 * July Leetcoding Challenge
 * 
 * Binary Tree Zigzag Level Order Traversal
 */

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        
        boolean even = true;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(even) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                
                if(node.left != null) {
                    queue.offer(node.left);
                }
                
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            even = !even;
            result.add(list);
        }
        
        return result;
    }
}