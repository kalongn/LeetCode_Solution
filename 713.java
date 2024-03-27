class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int product = 1, count = 0, windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            product *= nums[windowEnd];
            while (product >= k) {
                product /= nums[windowStart];
                windowStart++;
            }
            count += windowEnd - windowStart + 1;
        }
        return count;
    }
}
