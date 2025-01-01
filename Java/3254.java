import java.util.*;

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int length = nums.length;
        int[] result = new int[length - k + 1];
        Arrays.fill(result, -1);
        int counter = 1;

        for (int i = 0; i < length - 1; i++) {
            counter = nums[i] + 1 == nums[i + 1] ? counter + 1 : 1;

            if (counter >= k) {
                result[i - k + 2] = nums[i + 1];
            }
        }
        return result;
    }
}
