/**
 * 
 * Problem #297. Serialize and Deserialize Binary Tree
 * 
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root);
    }
    
    private String serializeHelper(TreeNode root)
    {
        if(root == null) {
            return "X" + ",";
        }
        
        
        String leftSubtree = serializeHelper(root.left);
        String rightSubtree = serializeHelper(root.right);
        
        return root.val + "," + leftSubtree + rightSubtree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        
        queue.addAll(Arrays.asList(data.split(",")));
        
        return deserializeHelper(queue);
    }
    
    private TreeNode deserializeHelper(Queue<String> queue)
    {
        String val = queue.poll();
        
        if(val.equals("X")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
        
            node.left = deserializeHelper(queue);
            node.right = deserializeHelper(queue);
        
            return node;
        }  
    }
}