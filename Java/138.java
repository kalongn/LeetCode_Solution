class Solution {
    public Node copyRandomList(Node head) {
        Node cursor = head;
        while (cursor != null) {
            Node newNode = new Node(cursor.val);
            newNode.next = cursor.next;
            cursor.next = newNode;
            cursor = newNode.next;
        }

        cursor = head;
        while (cursor != null) {
            if (cursor.random != null) {
                cursor.next.random = cursor.random.next;
            }
            cursor = cursor.next.next;
        }

        Node dummyHead = new Node(0), dummyCursor = dummyHead;
        cursor = head;
        while (cursor != null) {
            dummyCursor.next = cursor.next;
            dummyCursor = dummyCursor.next;

            cursor.next = cursor.next.next;
            cursor = cursor.next;
        }
        return dummyHead.next;
    }
}
