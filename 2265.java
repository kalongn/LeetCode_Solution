class Solution {
    int result = 0;

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int currentSum = left[0] + right[0] + root.val;
        int currentCount = left[1] + right[1] + 1;

        if (currentSum / currentCount == root.val) {
            result++;
        }

        return new int[] { currentSum, currentCount };
    }

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }
}
