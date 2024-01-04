import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (int c : counter.values()) {
            if (c == 1) {
                return -1;
            }
            result += Math.ceil((double) c / 3);
        }
        return result;
    }
}