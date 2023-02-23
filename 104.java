
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 1);
    }

    private int helper(TreeNode root, int prevDepth) {
        int leftSub = 0, rightSub = 0;
        if (root.left == null && root.right == null) {
            return prevDepth;
        }
        if (root.left != null) {
            leftSub = helper(root.left, prevDepth + 1);
        }
        if (root.right != null) {
            rightSub = helper(root.right, prevDepth + 1);
        }
        return Math.max(leftSub, rightSub);
    }
}
