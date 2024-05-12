class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] result = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = Integer.MIN_VALUE;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        result[i][j] = Math.max(result[i][j], grid[k][l]);
                    }
                }
            }
        }
        return result;
    }
}
