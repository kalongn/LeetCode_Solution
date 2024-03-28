import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int result = 0, start = -1;
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int end = 0; end < nums.length; end++) {
            frequency.put(nums[end], frequency.getOrDefault(nums[end], 0) + 1);
            while (frequency.get(nums[end]) > k) {
                start++;
                frequency.put(nums[start], frequency.get(nums[start]) - 1);
            }
            result = Math.max(result, end - start);
        }
        return result;
    }
}
