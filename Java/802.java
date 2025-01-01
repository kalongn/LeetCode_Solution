import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean[] isSafe = new boolean[V];

        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, pathVisited, isSafe);
            }
        }

        for (int i = 0; i < V; i++) {
            if (isSafe[i])
                safeNodes.add(i);
        }

        return safeNodes;
    }

    public boolean dfs(int[][] adj, int node, boolean[] visited,
            boolean[] pathVisited, boolean[] isSafe) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int it : adj[node]) {
            if (!visited[it]) {
                if (dfs(adj, it, visited, pathVisited, isSafe)) {
                    return true;
                }
            } else if (pathVisited[it]) {
                return true;
            }
        }
        isSafe[node] = true;
        pathVisited[node] = false;
        return false;
    }
}
