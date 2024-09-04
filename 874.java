import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obs.add(obstacle[0] + "," + obstacle[1]);
        }

        int max = 0;
        int[] currentPosition = new int[2];
        int[] currentDireciton = { 0, 1 };
        for (int i : commands) {
            if (i == -2) {
                int temp = currentDireciton[0];
                currentDireciton[0] = -currentDireciton[1];
                currentDireciton[1] = temp;
            } else if (i == -1) {
                int temp = currentDireciton[0];
                currentDireciton[0] = currentDireciton[1];
                currentDireciton[1] = -temp;
            } else if (i >= 1 && i <= 9) {
                for (int j = 0; j < i; j++) {
                    int nextX = currentPosition[0] + currentDireciton[0];
                    int nextY = currentPosition[1] + currentDireciton[1];
                    if (obs.contains(nextX + "," + nextY)) {
                        break;
                    }
                    currentPosition[0] = nextX;
                    currentPosition[1] = nextY;
                }
                max = Math.max(max, currentPosition[0] * currentPosition[0] + currentPosition[1] * currentPosition[1]);
            }
        }

        return max;
    }
}
