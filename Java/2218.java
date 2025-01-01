import java.util.List;

class Solution {
    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] mv = new int[k + 1];
        int[] pileSum = new int[k + 1];
        for (List<Integer> pile : piles) {
            int n = Math.min(k, pile.size());
            int sum = 0;
            for (int i = 1; i <= n; i++)
                pileSum[i] = sum += pile.get(i - 1);
            for (int i = k; i > 0; i--) {
                int max = 0;
                for (int j = Math.min(i, n); j >= 0; j--)
                    max = Math.max(max, pileSum[j] + mv[i - j]);
                mv[i] = max;
            }
        }
        return mv[k];
    }
}
