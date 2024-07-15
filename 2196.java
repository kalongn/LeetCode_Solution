import java.util.*;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] description : descriptions) {
            map.putIfAbsent(description[1], new TreeNode(description[1]));
            map.putIfAbsent(description[0], new TreeNode(description[0]));
            if (description[2] == 1) {
                map.get(description[0]).left = map.get(description[1]);
            } else {
                map.get(description[0]).right = map.get(description[1]);
            }
            children.add(description[1]);
        }

        for (TreeNode node : map.values()) {
            if (!children.contains(node.val)) {
                return node;
            }
        }

        return null;
    }
}
