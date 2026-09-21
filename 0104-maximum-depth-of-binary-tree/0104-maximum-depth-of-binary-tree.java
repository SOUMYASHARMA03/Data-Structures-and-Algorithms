class Solution {
    public int maxDepth(TreeNode root) {
        // Base case: if the current node is null, the depth is 0
        if (root == null) {
            return 0;
        }
        
        // Recursively find the depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // The maximum depth of the current node is the max of its subtrees plus 1
        return Math.max(leftDepth, rightDepth) + 1;
    }
}