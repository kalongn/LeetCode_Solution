import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long result = 0;
        long currentSum = 0;
        int left = 0;
        int right = 0;

        HashMap<Integer, Integer> numLastSaw = new HashMap<>();

        while (right < nums.length) {
            int currNum = nums[right];
            int lastSaw = numLastSaw.getOrDefault(currNum, -1);

            while (left <= lastSaw || right - left + 1 > k) {
                currentSum -= nums[left];
                left++;
            }

            numLastSaw.put(currNum, right);
            currentSum += nums[right];
            if (right - left + 1 == k) {
                result = Math.max(result, currentSum);
            }
            right++;
        }
        return result;
    }
}