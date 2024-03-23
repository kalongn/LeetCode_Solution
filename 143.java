class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode first = head, second = head;
        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
        }
        ListNode preMiddle = first, preCurrent = first.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        first = head;
        second = preMiddle.next;

        while (first != preMiddle) {
            preMiddle.next = second.next;
            second.next = first.next;
            first.next = second;
            first = second.next;
            second = preMiddle.next;
        }
    }
}
