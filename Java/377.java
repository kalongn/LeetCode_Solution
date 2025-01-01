class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        return findCombination(dp, nums, target);
    }

    public int findCombination(Integer[] dp, int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }

        if (dp[target] != null)
            return dp[target];

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += findCombination(dp, nums, target - nums[i]);
        }

        dp[target] = ans;
        return dp[target];
    }
}
