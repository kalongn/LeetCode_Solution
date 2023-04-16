import java.util.Arrays;

class Solution {
    public int numWays(String[] words, String target) {
        if (words[0].length() < target.length()) {
            return 0;
        }

        int mod = (int) (1e9 + 7);
        int len = words[0].length();
        int[][] charCounts = new int[len][26];

        for (String word : words) {
            for (int i = 0; i < len; i++) {
                charCounts[i][word.charAt(i) - 'a']++;
            }
        }

        int[] dp = new int[len - target.length() + 2];
        Arrays.fill(dp, 1);

        for (int i = target.length() - 1; i >= 0; i--) {
            int[] temp = new int[len - target.length() + 2];
            for (int j = dp.length - 2; j >= 0; j--) {
                int count = (int) (((long) charCounts[len - (target.length() - i) - (dp.length - 2 - j)][target
                        .charAt(i) - 'a'] * dp[j]) % mod);
                temp[j] = (temp[j + 1] + count) % mod;
            }
            temp[temp.length - 1] = 1;
            dp = temp;
        }
        return dp[0];
    }
}
