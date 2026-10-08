class Solution {
    public int mySqrt(int x) {
        // Base cases for 0 and 1
        if (x < 2) {
            return x;
        }
        
        int left = 1;
        int right = x;
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Safe from overflow equivalent to: mid * mid <= x
            if (mid <= x / mid) {
                ans = mid;        // Save the closest floor value found so far
                left = mid + 1;   // Try to find a larger value
            } else {
                right = mid - 1;  // mid is too large, search lower half
            }
        }
        
        return ans;
    }
}
