class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] direction = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] result = new int[rows * cols][2];
        int index = 0;

        for (int step = 1, dirIndex = 0; index < rows * cols; step++) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < step; j++) {
                    if (rStart >= 0 && rStart < rows &&
                        cStart >= 0 && cStart < cols) {

                        result[index][0] = rStart;
                        result[index][1] = cStart;
                        index++;
                    }
                    rStart += direction[dirIndex][0];
                    cStart += direction[dirIndex][1];
                }
                dirIndex = (dirIndex + 1) % 4;
            }
        }
        return result;
    }
}
