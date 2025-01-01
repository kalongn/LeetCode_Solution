import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length - 1] - position[0];

        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (validate(position, mid, m)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private boolean validate(int[] position, int gap, int m) {
        int prev = position[0];
        int ballsPlaced = 1;
        for (int i = 1; i < position.length && ballsPlaced < m; i++) {
            if (position[i] - prev >= gap) {
                ballsPlaced++;
                prev = position[i];
            }
        }
        return ballsPlaced == m;
    }
}
