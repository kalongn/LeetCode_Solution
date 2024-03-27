class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1') {
                    DFSFlip(grid, x, y);
                    result++;
                }
            }
        }
        return result;
    }

    private void DFSFlip(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';
        DFSFlip(grid, x + 1, y);
        DFSFlip(grid, x - 1, y);
        DFSFlip(grid, x, y + 1);
        DFSFlip(grid, x, y - 1);
    }
}
