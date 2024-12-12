import java.util.*;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> infixList = new ArrayList<>(k);
        infix(root, infixList, k);
        return infixList.get(k - 1);
    }

    private void infix(TreeNode root, List<Integer> infixList, int k) {
        if (root == null) {
            return;
        }
        infix(root.left, infixList, k);
        infixList.add(root.val);
        if (infixList.size() == k) {
            return;
        }
        infix(root.right, infixList, k);
    }
}