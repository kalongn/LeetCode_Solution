class Solution {
    private final int[][] directions = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 },
    };

    private boolean isCellLand(int x, int y, int[][] grid) {
        return grid[x][y] == 1;
    }

    private boolean isSubIsland(
            int x,
            int y,
            int[][] grid1,
            int[][] grid2,
            boolean[][] visited) {
        int totalRows = grid2.length;
        int totalCols = grid2[0].length;
        boolean isSubIsland = true;

        if (!isCellLand(x, y, grid1)) {
            isSubIsland = false;
        }

        for (int[] direction : directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            if (nextX >= 0 &&
                    nextY >= 0 &&
                    nextX < totalRows &&
                    nextY < totalCols &&
                    !visited[nextX][nextY] &&
                    isCellLand(nextX, nextY, grid2)) {
                visited[nextX][nextY] = true;
                boolean nextCellIsPartOfSubIsland = isSubIsland(
                        nextX,
                        nextY,
                        grid1,
                        grid2,
                        visited);
                isSubIsland = isSubIsland && nextCellIsPartOfSubIsland;
            }
        }
        return isSubIsland;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int totalRows = grid2.length;
        int totalCols = grid2[0].length;

        boolean[][] visited = new boolean[totalRows][totalCols];
        int subIslandCounts = 0;

        for (int x = 0; x < totalRows; ++x) {
            for (int y = 0; y < totalCols; ++y) {
                if (!visited[x][y] && isCellLand(x, y, grid2)) {
                    visited[x][y] = true;
                    if (isSubIsland(x, y, grid1, grid2, visited)) {
                        subIslandCounts += 1;
                    }
                }
            }
        }
        return subIslandCounts;
    }
}
