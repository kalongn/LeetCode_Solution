class Solution {
    public ListNode doubleIt(ListNode head) {
        if (head.val > 4) {
            head = new ListNode(0, head);
        }

        ListNode cursor = head;
        while (cursor != null) {
            cursor.val = (cursor.val * 2) % 10;
            if (cursor.next != null && cursor.next.val > 4) {
                cursor.val++;
            }
            cursor = cursor.next;
        }

        return head;
    }
}
