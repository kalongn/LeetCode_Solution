class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int minAbsVal = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int[] row : matrix) {
            for (int i : row) {
                totalSum += Math.abs(i);
                negativeCount = i < 0 ? negativeCount + 1 : negativeCount;
                minAbsVal = Math.min(minAbsVal, Math.abs(i));
            }
        }

        if (negativeCount % 2 != 0) {
            // 2 * as the addition then the negative subtraction
            totalSum -= 2 * minAbsVal;
        }

        return totalSum;
    }
}