class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cursor = head, prev = null;
        while (cursor.next != null) {
            prev = cursor;
            cursor = cursor.next;
            int gcd = gcd(prev.val, cursor.val);
            ListNode newNode = new ListNode(gcd, cursor);
            prev.next = newNode;
        }
        return head;
    }

    private int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
}
