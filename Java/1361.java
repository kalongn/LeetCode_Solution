import java.util.*;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] seen = new boolean[n];
        for (int i : leftChild) {
            if (i == -1) {
                continue;
            }
            seen[i] = true;
        }
        for (int i : rightChild) {
            if (i == -1) {
                continue;
            }
            seen[i] = true;
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                root = i;
            }
        }
        if (root == -1) {
            return false;
        }
        seen = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(root);
        seen[root] = true;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            int[] children = { leftChild[node], rightChild[node] };
            for (int child : children) {
                if (child != -1) {
                    if (seen[child]) {
                        return false;
                    }
                    stack.push(child);
                    seen[child] = true;
                }
            }
        }
        for (boolean i : seen) {
            if (!i) {
                return false;
            }
        }
        return true;
    }
}
