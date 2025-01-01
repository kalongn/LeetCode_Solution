import java.util.*;

class Solution {
    public int countNicePairs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - rev(nums[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        final int MOD = (int) 1e9 + 7;
        for (int num : nums) {
            result = (result + map.getOrDefault(num, 0)) % MOD;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return result;
    }

    public int rev(int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }
}