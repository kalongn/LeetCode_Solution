import java.util.*;

class Solution {

    Map<Integer, Boolean> memo = new HashMap<>();

    private boolean prefix(int[] nums, int index) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        boolean result = false;

        if (index > 0 && nums[index] == nums[index - 1]) {
            result |= prefix(nums, index - 2);
        }
        if (index > 1 && nums[index] == nums[index - 1] && nums[index - 1] == nums[index - 2]) {
            result |= prefix(nums, index - 3);
        }
        if (index > 1 && nums[index] == nums[index - 1] + 1 && nums[index - 1] == nums[index - 2] + 1) {
            result |= prefix(nums, index - 3);
        }
        memo.put(index, result);
        return result;
    }

    public boolean validPartition(int[] nums) {
        memo.put(-1, true);
        return prefix(nums, nums.length - 1);
    }
}