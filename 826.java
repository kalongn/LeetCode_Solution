import java.util.*;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] combined = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            combined[i][0] = difficulty[i];
            combined[i][1] = profit[i];
        }
        Arrays.sort(combined, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 0;
        for (int i = 0; i < worker.length; i++) {
            int currentMax = 0;
            for (int j = 0; j < combined.length; j++) {
                if (worker[i] < combined[j][0]) {
                    break;
                }
                currentMax = Math.max(currentMax, combined[j][1]);
            }
            result += currentMax;
        }
        return result;
    }
}
