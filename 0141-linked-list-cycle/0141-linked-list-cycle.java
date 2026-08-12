public class Solution {
    public boolean hasCycle(ListNode head) {
        // Handle empty list or single node with no cycle
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Traverse the list at two different speeds
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Moves 1 step
            fast = fast.next.next;     // Moves 2 steps
            
            // If pointers meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }
        
        // Fast pointer reached the end of the list
        return false;
    }
}