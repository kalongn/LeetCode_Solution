import java.util.*;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> heap = new PriorityQueue<>();

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode Node = bfs.poll();
                sum += Node.val;
                if (Node.left != null) {
                    bfs.offer(Node.left);
                }
                if (Node.right != null) {
                    bfs.offer(Node.right);
                }
            }

            heap.offer(sum);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        if (heap.size() < k) {
            return -1;
        }
        return heap.peek();
    }
}
