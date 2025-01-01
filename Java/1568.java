class Solution {
    public int minDays(int[][] grid) {
        int islandCount = countIslands(grid);
        if (islandCount != 1) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                grid[i][j] = 0;
                islandCount = countIslands(grid);

                if (islandCount != 1) {
                    return 1;
                }
                grid[i][j] = 1;
            }
        }

        return 2;
    }

    private int countIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    exploreIsland(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void exploreIsland(int[][] grid, int row, int column, boolean[][] visited) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] == 0
                || visited[row][column]) {
            return;
        }
        visited[row][column] = true;
        exploreIsland(grid, row - 1, column, visited);
        exploreIsland(grid, row + 1, column, visited);
        exploreIsland(grid, row, column - 1, visited);
        exploreIsland(grid, row, column + 1, visited);
    }
}
