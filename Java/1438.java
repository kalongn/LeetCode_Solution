class Solution {
    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minIndex = 0;
        int minValue = nums[0];
        int maxValue = nums[0];
        int maxIndex = 0;
        int longestArray = 0;

        int left = 0;
        int right = 1;

        while (right < nums.length) {
            // if current value (right pointer) satisfies the limit, expand the window and
            // continue)
            if (Math.abs(nums[right] - minValue) <= limit && Math.abs(nums[right] - maxValue) <= limit) {
                // check if max value and index needs to be updated.
                if (nums[right] > maxValue) {
                    maxValue = nums[right];
                    maxIndex = right;
                }
                // check if min value and index needs to be updated.
                if (nums[right] < minValue) {
                    minValue = nums[right];
                    minIndex = right;
                }
                right++;
                continue;
            }

            // window is broken. Identify if window needs to start from next index of
            // MinIndex or MaxIndex.

            longestArray = Math.max(longestArray, right - left);

            int nextIndex = Math.max(minIndex, maxIndex); // try to skip to the maximum index
            if (Math.abs(nums[nextIndex] - nums[right]) <= limit) {
                nextIndex = Math.min(minIndex, maxIndex);
            }

            // skip values until the condition is satisfied.
            while (Math.abs(nums[nextIndex] - nums[right]) > limit && nextIndex < right) {
                nextIndex++;
            }
            minIndex = nextIndex;
            maxIndex = nextIndex;
            minValue = nums[nextIndex];
            maxValue = nums[nextIndex];
            left = nextIndex;
            right = nextIndex;
            right++;
        }
        longestArray = Math.max(longestArray, right - left);
        return longestArray;

    }
}