from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        def helper(left, right):
            if not left or not right:
                return left == right
            elif left.val != right.val:
                return False
            return helper(left.left, right.right) and helper(left.right, right.left)

        return helper(root.left, root.right)
