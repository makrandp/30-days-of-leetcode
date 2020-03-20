/**
 * Leetcode problem #430. Flatten a Multilevel Doubly Linked List
 * 
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */


class Solution {
    public Node flatten(Node head) {
        if(head == null) {
            return null;
        }
        
        Stack<Node> stack = new Stack<Node>();
        
        Node temp = head; //store head reference
        
        while(head != null) 
        {
            //if child found then add next node to the stack
            if(head.child != null) {          
                if(head.next != null) {
                    stack.push(head.next);
                }
                
                //we move to the child node
                head.next = head.child;
                head.next.prev = head;
                head.child = null; //IMP
                    
            } else if(head.next == null && !stack.isEmpty()) {
                //pop the node from the stack
                Node node = stack.pop();
                //move next
                head.next = node;
                head.next.prev = head; 
            }
            
            //keep moving forward
            head = head.next;
        }

        return temp;
    }
}


class Solution2 {
    public Node flatten(Node head) {
        if(head == null) {
            return null;
        }
        
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        
        Node prev = new Node(0);
        
        while(!stack.isEmpty()) {
            Node current = stack.pop();
            current.prev = prev;
            prev.next = current;
            prev = current;
            
            if(current.next != null) {
                stack.push(current.next);
            }
            
            if(current.child != null) {
                stack.push(current.child);
                current.child = null; //IMP
            }
        }
        
        head.prev = null;
        return head;
    }
}