
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
    public boolean isPalindrome(ListNode head) {
        ListNode middle = middleNode(head);
        ListNode tailAsHead = reverseLinked(middle);
        while (head != null && tailAsHead != null) {
            if (head.val != tailAsHead.val) {
                return false;
            }
            head = head.next;
            tailAsHead = tailAsHead.next;
        }
        return true;
    }

    /*
     * the goal of this method is return 1 node over the middle node for
     * odd numbers of linkedList and the higher index of the middle in an even
     * LinkedList.
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /* Return the new head after the LinkedList is reversed */
    public ListNode reverseLinked(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head, prev = null, next = current.next;

        while (current != null) {
            current.next = prev;
            prev = current;
            current = next;
            if (current != null) {
                next = current.next;
            }
        }
        return prev;
    }
}
