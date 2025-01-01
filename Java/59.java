class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int direction = 0;
        int row = 0, col = 0;
        while (count <= n * n) {
            result[row][col] = count++;
            int r = Math.floorMod(row + dir[direction][0], n);
            int c = Math.floorMod(col + dir[direction][1], n);
            if (result[r][c] != 0) {
                direction = (direction + 1) % 4;
            }
            row += dir[direction][0];
            col += dir[direction][1];
        }
        return result;
    }
}
