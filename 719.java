import java.util.*;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int low = 0, high = nums[n - 1] - nums[0];
        while (low < high) {
            int mid = (low + high) / 2;
            int count = countPairsWithMaxDistance(nums, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countPairsWithMaxDistance(int[] nums, int maxDistance) {
        int count = 0;
        int n = nums.length;
        int left = 0;

        for (int right = 0; right < n; ++right) {
            // Adjust the left pointer to maintain the window with distances <=
            // maxDistance
            while (nums[right] - nums[left] > maxDistance) {
                ++left;
            }
            // Add the number of valid pairs ending at the current right index
            count += right - left;
        }
        return count;
    }
}
