import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numLine = new HashSet<>();
        for (int i : nums) {
            numLine.add(i);
        }
        int max = 0;
        for (int i : nums) {
            numLine.add(i);
            int winSize = 1;
            int temp = i;
            while (numLine.contains(temp - 1)) {
                winSize++;
                temp--;
                numLine.remove(temp);
            }
            temp = i;
            while (numLine.contains(temp + 1)) {
                winSize++;
                temp++;
                numLine.remove(temp);
            }
            max = Math.max(max, winSize);
        }
        return max;
    }
}