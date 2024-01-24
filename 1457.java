class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int path) {
        if (root == null) {
            return 0;
        }
        path ^= (1 << root.val);
        if (root.left == null && root.right == null) {
            return (path & (path - 1)) == 0 ? 1 : 0;
        }
        return helper(root.left, path) + helper(root.right, path);
    }
}
