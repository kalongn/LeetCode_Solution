class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int subArrayStartIndex = 0;
        int latestMinIndex = -1;
        int latestMaxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            // invalid sub array, start over
            if (nums[i] < minK || nums[i] > maxK) {
                latestMinIndex = -1;
                latestMaxIndex = -1;
                subArrayStartIndex = i + 1;
            }
            if (nums[i] == minK) {
                latestMinIndex = i;
            }
            if (nums[i] == maxK) {
                latestMaxIndex = i;
            }
            result += Math.max(0L, Math.min(latestMinIndex, latestMaxIndex) - subArrayStartIndex + 1);
        }
        return result;
    }
}
