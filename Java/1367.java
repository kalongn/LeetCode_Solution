class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(TreeNode node, ListNode head) {
        if (head == null) {
            return true;
        }
        if (node == null) {
            return false;
        }
        if (node.val != head.val) {
            return false;
        }
        return dfs(node.left, head.next) || dfs(node.right, head.next);
    }

}
