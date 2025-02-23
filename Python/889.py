# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def constructFromPrePost(
        self, preorder: List[int], postorder: List[int]
    ) -> Optional[TreeNode]:
        pre, post = 0, 0

        def construct():
            nonlocal pre, post
            root = TreeNode(preorder[pre])
            pre += 1

            if root.val != postorder[post]:
                root.left = construct()

            if root.val != postorder[post]:
                root.right = construct()

            post += 1
            return root

        return construct()
