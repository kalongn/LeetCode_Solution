class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode left = head, right = head, prev = null, prevTwo = null;
        while (left != null && right != null) {
            right = right.next;
            int current = 0;
            while (right != null && right.val != 0) {
                current += right.val;
                right = right.next;
            }
            left.val = current;
            prevTwo = prev;
            prev = left;
            left = left.next;
        }
        prevTwo.next = null;
        return head;
    }
}
