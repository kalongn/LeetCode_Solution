from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        def helper(root):
            if not root:
                return
            result.append(root.val)
            helper(root.left)
            helper(root.right)

        helper(root)
        return result
