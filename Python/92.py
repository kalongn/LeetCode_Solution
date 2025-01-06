from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseBetween(
        self, head: Optional[ListNode], left: int, right: int
    ) -> Optional[ListNode]:
        dummy = left_prev = ListNode(0, head)
        cursor = head
        for i in range(left - 1):
            left_prev = cursor
            cursor = cursor.next

        prev = None
        for i in range(right - left + 1):
            temp = cursor.next
            cursor.next = prev
            prev = cursor
            cursor = temp

        left_prev.next.next = cursor
        left_prev.next = prev

        return dummy.next
