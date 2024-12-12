class Solution {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[] { root.val };
        helper(root, result);
        return result[0];
    }

    private int helper(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(helper(root.left, result), 0);
        int rightMax = Math.max(helper(root.right, result), 0);

        result[0] = Math.max(result[0], root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}