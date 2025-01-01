class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }
        int[][] arr = new int[m][n];
        int currentRow = 0, currentCol = 0;
        for (int i = 0; i < original.length; i++) {
            arr[currentRow][currentCol] = original[i];
            currentCol++;
            if (currentCol == n) {
                currentRow++;
                currentCol = 0;
            }
        }
        return arr;
    }
}
