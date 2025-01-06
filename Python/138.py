from typing import Optional


class Node:
    def __init__(self, x: int, next: "Node" = None, random: "Node" = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: "Optional[Node]") -> "Optional[Node]":
        cursor = head
        while cursor:
            new_node = Node(cursor.val, cursor.next, cursor.random)
            cursor.next = new_node
            cursor = new_node.next

        cursor = head
        while cursor:
            if cursor.next.random != None:
                cursor.next.random = cursor.next.random.next
            cursor = cursor.next.next

        dummy = dummy_cursor = Node(-1)
        cursor = head
        while cursor:
            dummy_cursor.next = cursor.next
            cursor.next = cursor.next.next
            cursor = cursor.next
            dummy_cursor = dummy_cursor.next

        return dummy.next
