import java.util.List;
import java.util.ArrayList;

class Solution {
    public int makeConnected(int n, int[][] connections) {

        /* Count of Nodes -> N */
        int N = n;

        /* Count of Edges -> E */
        int E = connections.length;

        int R = 0;
        int C = 0;

        if (E < N - 1)
            return -1;

        /* Create Adjaceny List */
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] c : connections) {
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(c[0]);
        }

        boolean[] visited = new boolean[n];

        /* Perform DFS traversal to count components -> C */
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                C++;
            }
        }

        /* Calculate Redundant Edges -> R */
        R = E - ((N - 1) - (C - 1));

        if (R < C - 1)
            return -1;

        return C - 1;
    }

    /* DFS Traversal */
    public void dfs(List<List<Integer>> adj, boolean[] visited, int i) {

        if (visited[i])
            return;

        visited[i] = true;

        List<Integer> connection = adj.get(i);
        for (int c : connection) {
            if (!visited[c])
                dfs(adj, visited, c);
        }
        return;
    }
}
