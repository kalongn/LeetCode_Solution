from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        def dfs(root):
            if not root:
                return (0, 0)  # rob, not_rob

            left_rob, left_not_rob = dfs(root.left)
            right_rob, right_not_rob = dfs(root.right)

            rob = root.val + left_not_rob + right_not_rob
            not_rob = max(left_rob, left_not_rob) + max(right_rob, right_not_rob)

            return (rob, not_rob)

        return max(dfs(root))
