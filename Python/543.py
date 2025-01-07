from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        maxD = 0

        def helper(root):
            nonlocal maxD
            if not root:
                return 0

            left = helper(root.left)
            right = helper(root.right)

            maxD = max(maxD, left + right)
            return 1 + max(left, right)

        helper(root)
        return maxD
