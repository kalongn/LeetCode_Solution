class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        int n = grid.length - 2, m = grid[0].length - 2;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (isMagicSquare(grid, row, col)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int currentNum = grid[row + i][col + j];
                if (currentNum < 1 || currentNum > 9 || seen[currentNum]) {
                    return false;
                }
                seen[currentNum] = true;
            }
        }

        int d1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int d2 = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];

        if (d1 != d2) {
            return false;
        }

        int r1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int r2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
        int r3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];

        if (r1 != d1 || r2 != d1 || r3 != d1) {
            return false;
        }

        int c1 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int c2 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
        int c3 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];

        if (c1 != d1 || c2 != d1 || c3 != d1) {
            return false;
        }

        return true;
    }
}
