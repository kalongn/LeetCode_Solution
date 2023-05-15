
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head, fast = head;
        ListNode kthNodeFront, kthNodeEnd;
        while (k != 1) {
            fast = fast.next;
            k--;
        }
        kthNodeFront = fast;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        kthNodeEnd = slow;
        int temp = kthNodeEnd.val;
        kthNodeEnd.val = kthNodeFront.val;
        kthNodeFront.val = temp;
        return head;
    }
}