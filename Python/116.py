from typing import Optional


# Definition for a Node.
class Node:
    def __init__(
        self,
        val: int = 0,
        left: "Node" = None,
        right: "Node" = None,
        next: "Node" = None,
    ):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: Optional[Node]) -> Optional[Node]:
        if not root:
            return None

        queue = [root]

        while queue:
            prev = None
            cur_level_length = len(queue)
            for _ in range(cur_level_length):
                cur_node = queue.pop()
                cur_node.next = prev
                prev = cur_node
                if cur_node.right:
                    queue.insert(0, cur_node.right)
                if cur_node.left:
                    queue.insert(0, cur_node.left)

        return root
