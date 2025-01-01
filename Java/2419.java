class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, result = 0, current = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
                result = 0;
                current = 0;
            }

            if (max == num) {
                current++;
            } else {
                current = 0;
            }

            result = Math.max(result, current);
        }
        return result;
    }
}
