import java.util.Arrays;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int result = 0;
        for (int i = 1; i < points.length; i++) {
            result = Math.max(result, points[i][0] - points[i - 1][0]);
        }
        return result;
    }
}
