from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.max_sum = float("-inf")

        def dfs(root):
            if not root:
                return 0

            left_max = max(dfs(root.left), 0)
            right_max = max(dfs(root.right), 0)

            max_node_is_root = root.val + left_max + right_max
            self.max_sum = max(self.max_sum, max_node_is_root)
            return root.val + max(left_max, right_max)

        dfs(root)
        return self.max_sum
