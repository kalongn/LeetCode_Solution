class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int cols = matrix[0].length;
        int left = 0;
        int right = matrix.length * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (target == matrix[row][col]) {
                return true;
            }
            if (target < matrix[row][col]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}

class Solution2s {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;
        while (top <= bottom) {
            int center = top + (bottom - top) / 2;
            if (target > matrix[center][matrix[center].length - 1]) {
                top = center + 1;
            } else if (target < matrix[center][0]) {
                bottom = center - 1;
            } else {
                break;
            }
        }
        if (top > bottom) {
            return false;
        }
        int row = top + (bottom - top) / 2;
        int left = 0, right = matrix[row].length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target > matrix[row][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
