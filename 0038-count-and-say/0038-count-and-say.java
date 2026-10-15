public class Solution {
    public String countAndSay(int n) {
        // Base case: the 1st term of the sequence is always "1"
        if (n <= 0) return "";
        String result = "1";
        
        // Generate the sequence from 2 up to n
        for (int i = 2; i <= n; i++) {
            StringBuilder current = new StringBuilder();
            int length = result.length();
            int count = 1;
            
            // Loop through the previous sequence string to perform Run-Length Encoding (RLE)
            for (int j = 1; j < length; j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++; // Group consecutive identical digits
                } else {
                    current.append(count).append(result.charAt(j - 1)); // Say the count followed by the digit
                    count = 1; // Reset counter for the new digit group
                }
            }
            // Append the last group of digits
            current.append(count).append(result.charAt(length - 1));
            
            // Update result for the next loop iteration
            result = current.toString();
        }
        
        return result;
    }
}
