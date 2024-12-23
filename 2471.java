import java.util.*;

class Solution {
    public int minimumOperations(TreeNode root) {
        int swapRequired = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                TreeNode pulled = queue.poll();
                if (pulled.left != null) {
                    queue.add(pulled.left);
                }
                if (pulled.right != null) {
                    queue.add(pulled.right);
                }
                arr[i] = pulled.val;
            }
            swapRequired += getSwaps(arr);
        }
        return swapRequired;
    }

    private int getSwaps(int[] original) {
        int swaps = 0;
        int[] target = original.clone();
        Arrays.sort(target);

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            indexMap.put(original[i], i);
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != target[i]) {
                swaps++;

                int targetIndex = indexMap.get(target[i]);
                indexMap.put(original[i], targetIndex);
                original[targetIndex] = original[i];
            }
        }
        return swaps;
    }
}