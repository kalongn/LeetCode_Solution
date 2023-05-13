class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1]; // make dp 1 indexed
        dp[0] = 1;
        int mod = 1_000_000_007;

        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] += dp[i - zero];
            }
            if (i >= one) {
                dp[i] += dp[i - one];
            }
            dp[i] %= mod;
        }

        int result = 0;
        for (int i = low; i <= high; i++) {
            result += dp[i];
            result %= mod;
        }
        return result;
    }
}
