class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }

        int width = length / k, rem = length % k;

        ListNode[] result = new ListNode[k];
        current = head;
        for (int i = 0; i < k; i++) {
            ListNode currentHead = current;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; j++) {
                if (current != null) {
                    current = current.next;
                }
            }
            if (current != null) {
                ListNode previous = current;
                current = current.next;
                previous.next = null;
            }
            result[i] = currentHead;
        }
        return result;
    }
}
