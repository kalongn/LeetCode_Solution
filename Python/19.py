from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        fast = head

        for _ in range(n):
            fast = fast.next

        prev, slow = None, head
        while fast:
            fast = fast.next
            prev = slow
            slow = slow.next

        if prev == None:
            head = head.next
        else:
            prev.next = slow.next
        return head
