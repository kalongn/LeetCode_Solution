from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if not root:
            return result
        queue = []
        queue.append(root)
        while queue:
            cur_level = []
            length_of_queue = len(queue)
            for i in range(length_of_queue):
                popped = queue.pop(0)
                if popped.left:
                    queue.append(popped.left)
                if popped.right:
                    queue.append(popped.right)

                cur_level.append(popped.val)
            result.append(cur_level)

        return result
