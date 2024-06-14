import java.util.*;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (!(nums[i] > nums[i - 1])) {
                result += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return result;
    }
}
