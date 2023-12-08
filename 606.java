class Solution {
    public String tree2str(TreeNode root) {
        if (root == null)
            return "";
        if (root.left == null && root.right == null)
            return root.val + "";
        if (root.right == null)
            return root.val + "(" + tree2str(root.left) + ")";
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }
}
