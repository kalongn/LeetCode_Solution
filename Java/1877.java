import java.util.*;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            int currentPair = nums[i] + nums[nums.length - i - 1];
            if (maximum < currentPair) {
                maximum = currentPair;
            }
        }
        return maximum;
    }
}
