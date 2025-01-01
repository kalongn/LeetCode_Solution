class Solution {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    String result = "zzzzzzzzzzzzzzzzzzzzzzzzzz";

    public String smallestFromLeaf(TreeNode root) {
        helper(root, "");
        return result;
    }

    private void helper(TreeNode root, String currentString) {
        if (root == null) {
            return;
        }
        currentString = alphabet[root.val] + currentString;
        if (root.left == null && root.right == null) {
            if (currentString.compareTo(result) < 0) {
                result = currentString;
            }
        }
        helper(root.left, currentString);
        helper(root.right, currentString);
    }
}
