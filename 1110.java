import java.util.*;

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int i : to_delete) {
            toDeleteSet.add(i);
        }
        List<TreeNode> result = new ArrayList<>();
        root = helper(result, root, toDeleteSet);
        if (root != null) {
            result.add(root);
        }
        return result;
    }

    private TreeNode helper(List<TreeNode> result, TreeNode root, Set<Integer> delSet) {
        if (root == null) {
            return null;
        }

        root.left = helper(result, root.left, delSet);
        root.right = helper(result, root.right, delSet);

        if (delSet.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }
        return root;
    }
}
