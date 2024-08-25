import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        traverse(root.right, list);
        list.add(root.val);
    }
}
