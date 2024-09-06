import java.util.*;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        while (head != null && set.contains(head.val)) {
            head = head.next;
        }

        if (head == null) {
            return head;
        }

        ListNode cursor = head;
        while (cursor.next != null) {
            if (set.contains(cursor.next.val)) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }
        return head;
    }
}
