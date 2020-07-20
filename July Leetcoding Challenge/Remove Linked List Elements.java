/**
 * July Leetcoding challenge
 * 
 * Problem:  Remove Linked List Elements
 * 
 * 
 */

public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(-1);
    
    ListNode previous = dummy;
    ListNode current = head;
    dummy.next = head;
    
    while(current != null) {
        if(current.val == val) {
            previous.next = current.next;
        } else {
            previous = current;
        }
        
        current = current.next;
    }
    
    return dummy.next;
}
}