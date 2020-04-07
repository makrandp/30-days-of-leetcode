/**
 * Leetcode problem #2. Add Two Numbers
 * 
 * https://leetcode.com/problems/add-two-numbers/
 * 
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        if(l1 == null && l2 == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        int carry = 0;
        while(l1 != null || l2 != null) {
            
            int val1 = 0;
            if(l1 != null) {
                val1 = l1.val;
            }
            
            int val2 = 0;
            if(l2 != null) {
                val2 = l2.val;
            }
            
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            
            head.next = node;
            head = head.next;
            
            if(l1 != null) {
                l1 = l1.next;
            }
            
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        
        if(carry > 0) {
            ListNode node = new ListNode(carry);
            head.next = node;
            head = head.next;
        }
        
    
        return dummy.next;
    }
}