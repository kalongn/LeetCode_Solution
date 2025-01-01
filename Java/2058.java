class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, earliestCritIndex = -1;
        ListNode cursor = head.next, prev = head;
        int index = 1, prevCritIndex = -1;
        while (cursor.next != null) {
            if ((cursor.val > prev.val && cursor.val > cursor.next.val)
                    || (cursor.val < prev.val && cursor.val < cursor.next.val)) {
                if (earliestCritIndex == -1) {
                    earliestCritIndex = index;
                    prevCritIndex = index;
                } else {
                    min = Math.min(min, index - prevCritIndex);
                    max = index - earliestCritIndex;
                    prevCritIndex = index;
                }
            }
            prev = cursor;
            cursor = cursor.next;
            index++;
        }
        return max == Integer.MIN_VALUE || min == Integer.MAX_VALUE ? new int[] { -1, -1 } : new int[] { min, max };
    }
}
