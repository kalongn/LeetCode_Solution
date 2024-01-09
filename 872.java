import java.util.*;
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Sequence = new ArrayList<>();
        List<Integer> root2Sequence = new ArrayList<>();
        generateSequence(root1, root1Sequence);
        generateSequence(root2, root2Sequence);
        return root1Sequence.equals(root2Sequence);
    }

    public void generateSequence(TreeNode root, List<Integer> sequence) {
        if(root.left == null && root.right == null) {
            sequence.add(root.val);
        }
        if(root.left != null) {
            generateSequence(root.left, sequence);
        }
        if(root.right != null) {
            generateSequence(root.right, sequence);
        }
    }
}
