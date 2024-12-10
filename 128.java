import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = 0;
        for (int i : nums) {
            if (!set.contains(i - 1)) {
                int currWinSize = 1;
                while (set.contains(i + 1)) {
                    set.remove(i + 1);
                    currWinSize++;
                    i++;
                }
                max = Math.max(max, currWinSize);
            }
        }
        return max;
    }
}