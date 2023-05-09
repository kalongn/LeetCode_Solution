import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {

        }
        int n = matrix.length, m = matrix[0].length;
        int up = 0, down = n - 1;
        int left = 0, right = m - 1;
        while (result.size() < n * m) {
            for (int j = left; j <= right && result.size() < n * m; j++) {
                result.add(matrix[up][j]);
            }

            for (int i = up + 1; i <= down - 1 && result.size() < n * m; i++) {
                result.add(matrix[i][right]);
            }
            for (int j = right; j >= left && result.size() < n * m; j--) {
                result.add(matrix[down][j]);

            }
            for (int i = down - 1; i >= up + 1 && result.size() < n * m; i--) {
                result.add(matrix[i][left]);
            }

            left++;
            right--;
            up++;
            down--;
        }
        return result;
    }
}
