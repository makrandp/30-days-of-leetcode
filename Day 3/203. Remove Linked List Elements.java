/**
 * Leetcode problem #203. Remove Linked List Elements
 * 
 * https://leetcode.com/problems/remove-linked-list-elements/
 */


class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(-1);
        
        ListNode previous = temp;
        ListNode current = head;
        temp.next = head;
        
        while(current != null)
        {
            if(current.val == val) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            
            current = current.next;
        }
        
        return temp.next;
    }
}