class Solution {
    public String multiply(String num1, String num2) {
        // Handle edge case for zero
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        
        // Loop from right to left for both strings
        for (int i = m - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            
            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                
                // Product of current pair of digits
                int product = digit1 * digit2;
                
                // Indices in the result array where the product contributes
                int p1 = i + j;
                int p2 = i + j + 1;
                
                // Add current product to the existing value at position p2
                int sum = product + result[p2];
                
                // Update positions with carry and remainder
                result[p1] += sum / 10;
                result[p2] = sum % 10;
            }
        }
        
        // Convert the array back to a string, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int val : result) {
            if (!(sb.length() == 0 && val == 0)) {
                sb.append(val);
            }
        }
        
        return sb.toString();
    }
}
