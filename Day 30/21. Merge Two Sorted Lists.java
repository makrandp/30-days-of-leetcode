/**
 * 21. Merge Two Sorted Lists
 * 
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        
        if(l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            
            head = head.next;
        }
        
        head.next = l1 != null ? l1 : l2;
        
        return dummy.next;
    }
}