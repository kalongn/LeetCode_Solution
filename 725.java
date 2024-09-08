class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }

        int div = length / k, mod = length % k;
        ListNode prev = null;
        current = head;
        ListNode[] result = new ListNode[k];
        for (int i = 0; i < k; i++) {
            int amtToAppend = div;
            ListNode newSegment = current;
            if (mod > 0) {
                amtToAppend++;
                mod--;
            }
            for (int j = 0; j < amtToAppend; j++) {
                prev = current;
                current = current.next;
            }

            if (prev != null) {
                prev.next = null;
            }

            result[i] = newSegment;
        }

        return result;
    }
}