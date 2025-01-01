class Node {
    int val;
    Node prev, next;

    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class CustomStack {

    int currentSize, maxSize;
    Node head, cursor;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
        head = new Node(-1, null, null);
        cursor = head;
    }

    public void push(int x) {
        if (currentSize + 1 > maxSize) {
            return;
        }
        Node newNode = new Node(x, cursor, null);
        cursor.next = newNode;
        cursor = newNode;
        currentSize++;
    }

    public int pop() {
        if (cursor == head) {
            return -1;
        }
        Node deleteNode = cursor;
        cursor = cursor.prev;
        cursor.next = null;
        currentSize--;
        return deleteNode.val;
    }

    public void increment(int k, int val) {
        Node tempCursor = head;
        tempCursor = head.next;
        for (int i = 0; i < k && tempCursor != null; i++) {
            tempCursor.val += val;
            tempCursor = tempCursor.next;
        }
    }
}
