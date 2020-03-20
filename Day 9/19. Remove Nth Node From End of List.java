/**
 * Leetcode problem #19. Remove Nth Node From End of List
 * 
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //start one node behind so that we can delete even if there is only one node in the list
        ListNode fast = dummy, slow = dummy; 
        
        //move fast n+1 nodes ahead of slow
        for(int i = 0; i < n+1; i++) {
            fast = fast.next;
        }
        
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //now slow is n+1 nodes from the end of the linkedlist
        slow.next = slow.next.next;
    
        return dummy.next;
    }
}