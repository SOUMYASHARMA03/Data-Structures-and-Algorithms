/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Dummy node handles cases where 'left' is the first node (head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Step 1: Reach the node just before the 'left' position
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // Step 2: Set up pointers for the reversal section
        ListNode start = pre.next; // The first node to be reversed
        ListNode then = start.next; // The node that will be moved

        // Step 3: Reverse the sublist by shifting 'then' nodes behind 'pre'
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
