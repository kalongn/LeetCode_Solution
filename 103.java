import java.util.ArrayList;
import java.util.LinkedList;
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // the solution List
        List<List<Integer>> sol = new ArrayList<>();
        // recursive call, depth start with 0 in this case.
        travel(root, sol, 0);
        // return result
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
        // if the node is empty, then do nothing
        if (curr == null)
            return;

        // if the solution size is less then or equal to current level.
        // that mean we are in a new depth, hence we need a new list for that.
        if (sol.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        // get all the stuff in the current level
        List<Integer> collection = sol.get(level);
        // if the level is even, then add stuff in normal order (left -> right)
        // else the level is odd, add stuff in the reverse orer (right -> left)
        if (level % 2 == 0)
            collection.add(curr.val);
        else
            collection.add(0, curr.val);

        // recursively calling travel from left node then right node
        // pass the solution list alongside it and increment the depth by 1
        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }
}
