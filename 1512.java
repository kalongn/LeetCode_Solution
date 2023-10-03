import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    result++;
                }
            }
        }
        // return result;
        result = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : nums) {
            result += counts.getOrDefault(i, 0);
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        }
        return result;
    }
}
