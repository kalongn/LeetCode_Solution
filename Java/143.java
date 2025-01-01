class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode midHead = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (midHead != null) {
            ListNode temp = midHead.next;
            midHead.next = prev;
            prev = midHead;
            midHead = temp;
        }

        fast = head;
        slow = prev;
        while (slow != null) {
            ListNode temp1 = fast.next, temp2 = slow.next;
            fast.next = slow;
            slow.next = temp1;
            fast = temp1;
            slow = temp2;
        }
    }
}