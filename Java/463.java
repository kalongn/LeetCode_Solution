class Solution {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int current = 4;
                if (grid[i][j] == 1) {
                    if (i > 0 && grid[i - 1][j] == 1) {
                        current -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        current -= 2;
                    }
                    result += current;
                }
            }
        }
        return result;
    }
}
