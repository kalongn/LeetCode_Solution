import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPosition = points[0][1];
        int arrowCount = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPosition >= points[i][0] && arrowPosition <= points[i][1]) {
                continue;
            }
            arrowCount++;
            arrowPosition = points[i][1];
        }
        return arrowCount;
    }
}
