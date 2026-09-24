class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Base case: if lengths are different, they cannot be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        // Arrays to store the last seen position of each character (+1 to avoid default 0 conflict)
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // If the last seen positions don't match, the mapping is broken
            if (mapS[charS] != mapT[charT]) {
                return false;
            }

            // Record the current position (using i + 1 because arrays default initialize to 0)
            mapS[charS] = i + 1;
            mapT[charT] = i + 1;
        }

        return true;
    }
}
