import java.util.*;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode front = new ListNode(0, head);
        ListNode current = front;
        int prefixSum = 0;
        Map<Integer, ListNode> prefixSumToNode = new HashMap<>();
        prefixSumToNode.put(0, front);

        while (current != null) {
            prefixSum += current.val;
            prefixSumToNode.put(prefixSum, current);
            current = current.next;
        }

        prefixSum = 0;
        current = front;

        while (current != null) {
            prefixSum += current.val;
            current.next = prefixSumToNode.get(prefixSum).next;
            current = current.next;
        }
        return front.next;
    }
}
