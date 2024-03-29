class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }
        long result = 0;
        int start = 0, countMaxInWindow = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == max) {
                countMaxInWindow++;
            }
            while (k == countMaxInWindow) {
                if (nums[start] == max) {
                    countMaxInWindow--;
                }
                start++;
            }
            result += start;
        }
        return result;
    }
}
