import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater element for each number in nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        // Traverse nums2 to find the next greater element for all possible numbers
        for (int num : nums2) {
            // While stack is not empty and current number is greater than stack's top
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            // Push the current number onto the stack
            stack.push(num);
        }
        
        // Build the result array for nums1 using the map
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // If the element doesn't have a next greater item, default to -1
            ans[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
        
        return ans;
    }
}
