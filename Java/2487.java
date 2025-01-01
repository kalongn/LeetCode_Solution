class Solution {
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode temp = null;

        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);

        int maximum = 0;
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            maximum = Math.max(maximum, current.val);

            if (current.val < maximum) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
                ListNode deleted = current;
                current = current.next;
                deleted.next = null;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return reverseList(head);
    }
}
