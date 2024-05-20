class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int i, int currentResult) {
        if (i == nums.length) {
            return currentResult;
        }
        return helper(nums, i + 1, currentResult ^ nums[i]) + helper(nums, i + 1, currentResult);
    }
}
