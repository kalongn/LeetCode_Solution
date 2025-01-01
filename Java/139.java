import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        Set<String> dict = new HashSet<>(wordDict);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; !dp[i] && j <= n; j++) {
                dp[i] = dp[j] & dict.contains(s.substring(i, j));
            }
        }
        return dp[0];
    }
}
