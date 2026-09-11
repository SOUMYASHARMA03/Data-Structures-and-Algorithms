class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            // Convert character to its corresponding 1-26 value
            int value = c - 'A' + 1;
            // Shift the previous total by base 26 and add the new value
            result = result * 26 + value;
        }
        
        return result;
    }
}
