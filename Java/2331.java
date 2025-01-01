class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        return root.val == 2 ? evaluateTree(root.left) || evaluateTree(root.right)
                : evaluateTree(root.left) && evaluateTree(root.right);
    }
}
