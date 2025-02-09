from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head:
            return head

        prev = None
        cursor = head
        length = 0
        while cursor:
            prev = cursor
            cursor = cursor.next
            length += 1

        k %= length
        prev.next = head
        cursor = head

        for _ in range(length - k - 1):
            cursor = cursor.next

        result = cursor.next
        cursor.next = None

        return result
