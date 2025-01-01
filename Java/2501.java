import java.util.*;

class Solution {
    public int longestSquareStreak(int[] nums) {
        int longestStreak = 0;
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : nums) {
            uniqueNumbers.add(num);
        }
        for (int startNumber : nums) {
            int currentStreak = 0;
            long current = startNumber;
            while (uniqueNumbers.contains((int) current)) {
                currentStreak++;
                if (current * current > 1e5)
                    break;
                current *= current;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        return longestStreak < 2 ? -1 : longestStreak;
    }
}
