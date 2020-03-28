/**
 * Leetcode problem #328. Odd Even Linked List
 * 
 * https://leetcode.com/problems/odd-even-linked-list/
 */

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        
        ListNode odd = head, even = head.next;
        //save even head
        ListNode evenHead = even;
        
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        return head;
    }
}