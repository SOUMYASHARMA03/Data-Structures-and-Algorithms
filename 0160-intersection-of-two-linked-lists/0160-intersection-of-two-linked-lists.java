/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Boundary check
        if (headA == null || headB == null) return null;
        
        ListNode pA = headA;
        ListNode pB = headB;
        
        // Loop terminates when pointers meet (either at intersection node or null)
        while (pA != pB) {
            // Move to next node or redirect to the head of the opposite list
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        
        return pA;
    }
}
