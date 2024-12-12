import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int limit = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < limit; i++) {
                TreeNode polled = queue.poll();
                curLevel.add(polled.val);
                if (polled.left != null) {
                    queue.offer(polled.left);
                }
                if (polled.right != null) {
                    queue.offer(polled.right);
                }
            }
            result.add(curLevel);
        }
        return result;
    }
}