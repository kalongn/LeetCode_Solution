class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, helper(grid, i, j));
            }
        }
        return max;
    }

    private int helper(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int max = 0;
        int val = grid[i][j];
        grid[i][j] = 0;

        max = Math.max(max, helper(grid, i + 1, j));
        max = Math.max(max, helper(grid, i - 1, j));
        max = Math.max(max, helper(grid, i, j + 1));
        max = Math.max(max, helper(grid, i, j - 1));

        grid[i][j] = val;
        return max + val;
    }
}
