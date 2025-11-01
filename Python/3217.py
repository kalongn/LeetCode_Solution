# Definition for singly-linked list.
from typing import List, Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def modifiedList(
        self, nums: List[int], head: Optional[ListNode]
    ) -> Optional[ListNode]:
        dummyHead = ListNode(next=head)
        values = set(nums)
        cursor, prev = head, dummyHead
        while cursor:
            if cursor.val in values:
                prev.next = cursor.next
            else:
                prev = cursor
            cursor = cursor.next
        return dummyHead.next
