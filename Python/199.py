from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if not root:
            return result

        queue = []
        queue.append(root)
        i = 0
        while queue:
            cur_level = len(queue)
            for i in range(cur_level):
                popped = queue.pop(0)
                if popped.left:
                    queue.append(popped.left)
                if popped.right:
                    queue.append(popped.right)
                if i == cur_level - 1:
                    result.append(popped.val)

        return result
