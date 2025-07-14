# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def getDecimalValue(self, head: Optional[ListNode]) -> int:
        result = 0
        while head:
            result = 2 * result + head.val
            head = head.next

        return result
