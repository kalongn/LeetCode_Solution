class Solution {
    public Node copyRandomList(Node head) {
        Node cursor = head, next;
        while (cursor != null) {
            next = cursor.next;
            Node copy = new Node(cursor.val);
            cursor.next = copy;
            copy.next = next;
            cursor = next;
        }

        cursor = head;
        while (cursor != null) {
            if (cursor.random != null) {
                cursor.next.random = cursor.random.next;
            }
            cursor = cursor.next.next;
        }

        cursor = head;
        Node dummyHead = new Node(0);
        Node copy, copyCursor = dummyHead;
        while (cursor != null) {
            next = cursor.next.next;

            copy = cursor.next;
            copyCursor.next = copy;
            copyCursor = copy;

            cursor.next = next;
            cursor = next;
        }

        return dummyHead.next;
    }
}
