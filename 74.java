class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = n * m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midNum = matrix[mid / m][mid % m];
            if (midNum < target) {
                left = mid + 1;
            } else if (midNum > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}