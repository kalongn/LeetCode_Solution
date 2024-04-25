class Solution {
    // public int longestIdealString(String s, int k) {
    // if(s.length() == 1) {
    // return 1;
    // }
    // if(Math.abs(s.charAt(0) - s.charAt(1)) <= k) {
    // return Math.max(1 + longestIdealString(s.substring(1), k),
    // longestIdealString(s.substring(1), k));
    // }
    // return Math.max(longestIdealString(s.substring(1), k),
    // longestIdealString(s.substring(1), k));
    // }
    public int longestIdealString(String s, int k) {
        int dp[] = new int[26], result = 1, n = s.length();
        for (int ch = 0; ch < n; ch++) {
            int i = s.charAt(ch) - 'a';
            dp[i] = dp[i] + 1;

            for (int j = Math.max(0, i - k); j <= Math.min(25, i + k); j++) {
                if (i != j) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
