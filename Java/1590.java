import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum = (sum + i) % p;
        }
        int target = sum % p;
        if (target == 0) {
            return 0;
        }

        Map<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);

        int currentSum = 0;
        int result = n;
        for (int i = 0; i < n; i++) {
            currentSum = (currentSum + nums[i]) % p;
            int needed = (currentSum - target + p) % p;
            if (modMap.containsKey(needed)) {
                result = Math.min(result, i - modMap.get(needed));
            }
            modMap.put(currentSum, i);
        }
        return result == n ? -1 : result;
    }
}
