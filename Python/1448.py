# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def helper(root, max_val):
            if not root:
                return 0

            addition = 0
            if root.val >= max_val:
                addition = 1
                max_val = root.val

            return addition + helper(root.left, max_val) + helper(root.right, max_val)

        if not root:
            return 0
        max_val = root.val
        return 1 + helper(root.left, max_val) + helper(root.right, max_val)
