import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

class Pair<F, S> {
    private F first; // first member of pair
    private S second; // second member of pair

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}

class Solution {
    public List<TreeNode> allPossibleBST(int start, int end,
            Map<Pair<Integer, Integer>, List<TreeNode>> memo) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        if (memo.containsKey(new Pair<>(start, end))) {
            return memo.get(new Pair<>(start, end));
        }
        // Iterate through all values from start to end to construct left and right
        // subtree recursively.
        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftSubTrees = allPossibleBST(start, i - 1, memo);
            List<TreeNode> rightSubTrees = allPossibleBST(i + 1, end, memo);

            // Loop through all left and right subtrees and connect them to ith root.
            for (TreeNode left : leftSubTrees) {
                for (TreeNode right : rightSubTrees) {
                    TreeNode root = new TreeNode(i, left, right);
                    res.add(root);
                }
            }
        }
        memo.put(new Pair<>(start, end), res);
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        Map<Pair<Integer, Integer>, List<TreeNode>> memo = new HashMap<>();
        return allPossibleBST(1, n, memo);
    }
}
