import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjMatrix = new int[n][n];
        final int INF = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            Arrays.fill(adjMatrix[i], INF);
            adjMatrix[i][i] = 0;
        }

        for (int[] edge : edges) {
            adjMatrix[edge[0]][edge[1]] = edge[2];
            adjMatrix[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }

        int result = -1;
        int minimum = n;

        for (int i = 0; i < n; i++) {
            int currentCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && adjMatrix[i][j] <= distanceThreshold) {
                    currentCount++;
                }
            }
            if (currentCount <= minimum) {
                minimum = currentCount;
                result = i;
            }
        }

        return result;
    }
}
