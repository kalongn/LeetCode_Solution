from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class FindElements:

    def __init__(self, root: Optional[TreeNode]):
        self.seen = set()

        def helper(root, num):
            if not root:
                return
            self.seen.add(num)
            helper(root.left, num * 2 + 1)
            helper(root.right, num * 2 + 2)

        helper(root, 0)

    def find(self, target: int) -> bool:
        return target in self.seen
