import java.util.*;

class Solution {
    public int minGroups(int[][] mx) {
        int n = mx.length;
        int[] begin = new int[n], end = new int[n];
        for (int i = 0; i < n; i++) {
            begin[i] = mx[i][0];
            end[i] = mx[i][1];
        }

        // we sort the start & end time of each meeting separately
        Arrays.sort(begin);
        Arrays.sort(end);

        // i traverse all start time of meeting, j traverse end
        // if a meeting starts later than a meeting ends, they can use the same room
        // after we started all meetings (i reached n), how many meetings didn't end: n - j
        // that will be all meetings rooms we need
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (begin[i] > end[j]) {
                j++; // 1 line core logic
            }
        }
        return n - j;
    }
}
