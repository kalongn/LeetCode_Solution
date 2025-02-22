from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def recoverFromPreorder(self, traversal: str) -> Optional[TreeNode]:
        stack = []
        i, n = 0, len(traversal)

        while i < n:
            depth = 0
            while i < n and traversal[i] == "-":
                depth += 1
                i += 1

            value = 0
            while i < n and traversal[i].isdigit():
                value *= 10
                value += int(traversal[i])
                i += 1

            node = TreeNode(value)

            while len(stack) > depth:
                stack.pop()

            if stack:
                if stack[-1].left is None:
                    stack[-1].left = node
                else:
                    stack[-1].right = node

            stack.append(node)

        while len(stack) > 1:
            stack.pop()

        return stack[-1]
