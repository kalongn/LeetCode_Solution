import java.util.*;

class Solution {
    List<Integer> sortedList = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return createBST(0, sortedList.size() - 1);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        sortedList.add(root.val);
        inOrder(root.right);
    }

    private TreeNode createBST(int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        return new TreeNode(sortedList.get(mid), createBST(low, mid - 1), createBST(mid + 1, high));
    }
}
