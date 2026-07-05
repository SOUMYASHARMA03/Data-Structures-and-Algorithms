class Solution {
    public int lengthOfLongestSubstring(String s) {
         if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            if (lastSeen[currentChar] >= left) {
                left = lastSeen[currentChar] + 1;
            }
            
            lastSeen[currentChar] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    
}
}