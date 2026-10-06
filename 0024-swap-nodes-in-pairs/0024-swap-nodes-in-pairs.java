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
    public ListNode swapPairs(ListNode head) {
        // Base case: If the list is empty or has only one node, no swaps are needed.
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize a dummy node to maintain the new head reference easily.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Traverse the list while there is a pair of adjacent nodes to swap.
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            // Rewire the pointers to flip the pair
            first.next = second.next; // 1 -> 3
            second.next = first;       // 2 -> 1
            prev.next = second;       // prev -> 2

            // Move the 'prev' pointer two nodes ahead for the next iteration
            prev = first;
        }

        return dummy.next;
    }
}
