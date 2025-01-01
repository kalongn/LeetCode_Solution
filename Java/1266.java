class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int xDiff = points[i + 1][0] - points[i][0];
            int yDiff = points[i + 1][1] - points[i][1];
            totalTime += Math.max(Math.abs(xDiff), Math.abs(yDiff));
        }
        return totalTime;
    }
}
