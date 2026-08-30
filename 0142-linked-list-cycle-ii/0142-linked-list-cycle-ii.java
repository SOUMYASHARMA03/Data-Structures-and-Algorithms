public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode tortoise = head;
        ListNode hare = head;

        // Step 1: Determine if a cycle exists
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            // Cycle detected
            if (tortoise == hare) {
                // Step 2: Find the entry point of the cycle
                ListNode pointer1 = head;
                ListNode pointer2 = tortoise;

                while (pointer1 != pointer2) {
                    pointer1 = pointer1.next;
                    pointer2 = pointer2.next;
                }
                return pointer1; // Both pointers meet at the start of the cycle
            }
        }

        return null;
    }
}