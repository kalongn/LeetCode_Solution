import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Mapper(root);
        return res;
    }

    public String Mapper(TreeNode root) {
        if (root == null) {
            return "N";
        }
        String left = Mapper(root.left);
        String right = Mapper(root.right);
        String curr = root.val + " " + left + " " + right;

        map.put(curr, map.getOrDefault(curr, 0) + 1);

        if (map.get(curr) == 2) {
            res.add(root);
        }

        return curr;
    }
}