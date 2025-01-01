class Solution {
    public TreeNode bstToGst(TreeNode root) {
        int[] currentSum = new int[1];
        helper(root, currentSum);
        return root;
    }

    private void helper(TreeNode root, int[] currentSum) {
        if (root == null) {
            return;
        }
        helper(root.right, currentSum);
        currentSum[0] += root.val;
        root.val = currentSum[0];
        helper(root.left, currentSum);
    }
}