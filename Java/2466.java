import java.util.*;

class Solution {

    final int MOD = 1_000_000_007;
    int[] dp;

    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        int result = 0;
        for (int i = low; i <= high; i++) {
            result += helper(i, zero, one);
            result %= MOD;
        }
        return result;
    }

    private int helper(int end, int zero, int one) {
        if (dp[end] != -1) {
            return dp[end];
        }
        int sum = 0;
        if (end >= zero) {
            sum += helper(end - zero, zero, one);
        }
        if (end >= one) {
            sum += helper(end - one, zero, one);
        }
        dp[end] = sum % MOD;
        return dp[end];
    }
}