import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        backtrack(s, 0, currentPartition, result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        // Base case: If we've reached the end of the string, add the current partition to the results
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            // Check if the current substring s[start...end] is a palindrome
            if (isPalindrome(s, start, end)) {
                // Choose: add the valid substring to our path
                currentPartition.add(s.substring(start, end + 1));
                
                // Explore: recurse for the remaining suffix of the string
                backtrack(s, end + 1, currentPartition, result);
                
                // Unchoose: backtrack by removing the last element
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
