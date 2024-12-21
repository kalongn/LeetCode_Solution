import java.util.*;

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        int[] result = new int[1];

        dfs(0, -1, adjList, values, k, result);
        return result[0];
    }

    private int dfs(int current, int parent, List<Integer>[] adjList, int[] values, int k, int[] result) {
        int sum = 0;

        for (int neighbor : adjList[current]) {
            if (neighbor != parent) {
                sum += dfs(neighbor, current, adjList, values, k, result);
                sum %= k;
            }
        }

        sum += values[current];
        sum %= k;

        if (sum == 0) {
            result[0]++;
        }

        return sum;
    }
}