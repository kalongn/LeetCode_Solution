import java.util.*;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            int rowMax = Integer.MIN_VALUE;
            for (int i = 0; i < length; i++) {
                TreeNode pulled = queue.poll();
                rowMax = Math.max(rowMax, pulled.val);
                if (pulled.left != null) {
                    queue.add(pulled.left);
                }
                if (pulled.right != null) {
                    queue.add(pulled.right);
                }
            }
            result.add(rowMax);
        }
        return result;
    }
}