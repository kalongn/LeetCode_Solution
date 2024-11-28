import java.util.*;

class Solution {

    // Directions for movement: right, left, down, up
    private final int[][] directions = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 },
    };

    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Distance matrix to store the minimum obstacles removed to reach each cell
        int[][] minObstacles = new int[m][n];

        // Initialize all cells with a large value, representing unvisited cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minObstacles[i][j] = Integer.MAX_VALUE;
            }
        }

        minObstacles[0][0] = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] { 0, 0, 0 }); // {obstacles, row, col}

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int obstacles = current[0], row = current[1], col = current[2];

            // Explore all four possible directions from the current cell
            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];

                if (isValid(grid, newRow, newCol) &&
                        minObstacles[newRow][newCol] == Integer.MAX_VALUE) {
                    if (grid[newRow][newCol] == 1) {
                        // If it's an obstacle, add 1 to obstacles and push to the back
                        minObstacles[newRow][newCol] = obstacles + 1;
                        deque.addLast(
                                new int[] { obstacles + 1, newRow, newCol });
                    } else {
                        // If it's an empty cell, keep the obstacle count and push to the front
                        minObstacles[newRow][newCol] = obstacles;
                        deque.addFirst(new int[] { obstacles, newRow, newCol });
                    }
                }
            }
        }

        return minObstacles[m - 1][n - 1];
    }

    // Helper method to check if the cell is within the grid bounds
    private boolean isValid(int[][] grid, int row, int col) {
        return (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length);
    }
}