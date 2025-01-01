
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
    public int pairSum(ListNode head) {
        /*
         * List<Integer> values = new ArrayList<>();
         * ListNode current = head;
         * 
         * while(current != null) {
         * values.add(current.val);
         * current = current.next;
         * }
         * 
         * int i = 0, j = values.size() - 1, maxValue = Integer.MIN_VALUE;
         * while(i < j) {
         * maxValue = Math.max(maxValue, values.get(i) + values.get(j));
         * i++;
         * j--;
         * }
         * return maxValue;
         */
        int maxValue = 0;
        ListNode slow = head, fast = head, previous = null, current = head;
        while (fast != null) {
            fast = fast.next.next;
            current = slow;
            slow = slow.next;
            current.next = previous;
            previous = current;
        }
        while (slow != null) {
            maxValue = Math.max(maxValue, previous.val + slow.val);
            slow = slow.next;
            previous = previous.next;
        }
        return maxValue;
    }
}
