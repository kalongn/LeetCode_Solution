import java.util.*;

class Solution {

    public int stoneGameII(int[] piles) {
        int[] suffixSum = Arrays.copyOf(piles, piles.length);
        for (int i = suffixSum.length - 2; i >= 0; i--) {
            suffixSum[i] += suffixSum[i + 1];
        }

        return maxStones(suffixSum, 1, 0, new int[piles.length][piles.length]);
    }

    private int maxStones(
            int[] suffixSum,
            int maxTillNow,
            int currIndex,
            int[][] memo) {

        if (currIndex + 2 * maxTillNow >= suffixSum.length) {
            return suffixSum[currIndex];
        }
        if (memo[currIndex][maxTillNow] > 0) {
            return memo[currIndex][maxTillNow];
        }
        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= 2 * maxTillNow; i++) {
            res = Math.min(res, maxStones(suffixSum, Math.max(i, maxTillNow), currIndex + i, memo));
        }
        memo[currIndex][maxTillNow] = suffixSum[currIndex] - res;
        return memo[currIndex][maxTillNow];
    }
}