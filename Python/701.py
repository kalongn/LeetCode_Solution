from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:

        def helper(root):
            nonlocal val
            if not root.left and val < root.val:
                root.left = TreeNode(val)
                return
            elif not root.right and val > root.val:
                root.right = TreeNode(val)
                return

            if val < root.val:
                helper(root.left)
            else:
                helper(root.right)

        if not root:
            return TreeNode(val)

        helper(root)
        return root
