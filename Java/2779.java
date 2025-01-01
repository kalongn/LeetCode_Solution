import java.util.*;

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i : nums) {
        // for(int j = i - k; j <= i + k; j++) {
        // map.put(j, map.getOrDefault(j, 0) + 1);
        // }
        // }
        // int max = 0;
        // for(int i : map.values()) {
        // max = Math.max(max, i);
        // }
        // return max;

        Arrays.sort(nums);
        int j = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] - nums[i] <= 2 * k) {
                j++;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}