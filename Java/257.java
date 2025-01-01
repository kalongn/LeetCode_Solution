import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        helper(root, currentString, result);
        return result;
    }

    private void helper(TreeNode root, StringBuilder current, List<String> result) {
        int length = current.length();
        current.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(current.toString());
        }
        current.append("->");
        if (root.left != null) {
            helper(root.left, current, result);
        }
        if (root.right != null) {
            helper(root.right, current, result);
        }
        current.setLength(length);
    }
}
