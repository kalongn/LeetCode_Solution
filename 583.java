import java.util.ArrayList;
import java.util.List;

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
    List<Integer> sorted = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        inOrderTraverse(root);

        int min = 100001;
        for (int i = sorted.size() - 1; i > 0; i--) {
            min = Math.min(min, sorted.get(i) - sorted.get(i - 1));
        }
        return min;
    }

    private void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left);
        sorted.add(root.val);
        inOrderTraverse(root.right);
    }
}
