class Solution {
    public long maxPoints(int[][] points) {
        int cols = points[0].length;
        long[] currentRow = new long[cols], previousRows = new long[cols];

        for (int[] row : points) {
            long max = 0;

            for (int i = 0; i < cols; i++) {
                max = Math.max(max - 1, previousRows[i]);
                currentRow[i] = max;
            }

            max = 0;

            for (int i = cols - 1; i >= 0; i--) {
                max = Math.max(max - 1, previousRows[i]);
                currentRow[i] = Math.max(currentRow[i], max) + row[i];
            }

            previousRows = currentRow;
        }

        long result = 0;
        for (long i : previousRows) {
            result = Math.max(result, i);
        }
        return result;
    }
}
