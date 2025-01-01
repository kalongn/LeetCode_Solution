import java.util.*;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bin = new HashSet<>();
        for (int i : banned) {
            if (i <= n) {
                bin.add(i);
            }
        }

        int digit = 0;
        for (int i = 1; i <= n; i++) {
            if (bin.contains(i)) {
                continue;
            }
            if (maxSum - i < 0) {
                break;
            }
            maxSum -= i;
            digit++;
        }

        return digit;
    }
}