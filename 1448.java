class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + helper(root.left, root.val) + helper(root.right, root.val);
    }

    private int helper(TreeNode root, int curMax) {
        if (root == null) {
            return 0;
        }
        int addition = 0;
        if (root.val >= curMax) {
            addition = 1;
            curMax = root.val;
        }
        return addition + helper(root.left, curMax) + helper(root.right, curMax);
    }
}