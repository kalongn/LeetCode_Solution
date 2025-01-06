from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(
        self, l1: Optional[ListNode], l2: Optional[ListNode]
    ) -> Optional[ListNode]:
        (
            c1,
            c2,
        ) = (
            l1,
            l2,
        )
        dummy = dummy_head = ListNode()

        carry = False

        while c1 or c2:
            cur_sum = 0
            if c1 and c2:
                cur_sum = c1.val + c2.val
                c1 = c1.next
                c2 = c2.next
            elif c1:
                cur_sum = c1.val
                c1 = c1.next
            else:
                cur_sum = c2.val
                c2 = c2.next

            cur_sum += 1 if carry else 0
            carry = False

            if cur_sum > 9:
                carry = True
                cur_sum %= 10

            dummy.next = ListNode(cur_sum)
            dummy = dummy.next

        if carry:
            dummy.next = ListNode(1)

        return dummy_head.next
