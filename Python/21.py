from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeTwoLists(
        self, list1: Optional[ListNode], list2: Optional[ListNode]
    ) -> Optional[ListNode]:
        cursor1, cursor2 = list1, list2
        cursor = dummyHead = ListNode()
        while cursor1 or cursor2:
            if cursor1 and cursor2:
                if cursor1.val <= cursor2.val:
                    cursor.next = cursor1
                    cursor1 = cursor1.next
                else:
                    cursor.next = cursor2
                    cursor2 = cursor2.next
            elif cursor1:
                cursor.next = cursor1
                cursor1 = cursor1.next

            elif cursor2:
                cursor.next = cursor2
                cursor2 = cursor2.next
            cursor = cursor.next

        return dummyHead.next
