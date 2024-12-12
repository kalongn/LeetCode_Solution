class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (sameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean sameTree(TreeNode rootOne, TreeNode rootTwo) {
        if (rootOne == null && rootTwo == null) {
            return true;
        }
        if (rootOne != null && rootTwo != null && rootOne.val == rootTwo.val) {
            return sameTree(rootOne.left, rootTwo.left) && sameTree(rootOne.right, rootTwo.right);
        }
        return false;
    }
}