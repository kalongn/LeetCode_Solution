import java.util.*;

class Graph {
    List<List<int[]>> res;
    int n;

    public Graph(int n, int[][] edges) {
        this.n = n;
        res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            res.get(u).add(new int[] { v, w });
        }
    }

    public void addEdge(int[] edge) {
        int u = edge[0], v = edge[1], w = edge[2];
        res.get(u).add(new int[] { v, w });
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> nm = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        nm.offer(new int[] { node1, 0 });
        boolean[] visited = new boolean[n];
        while (!nm.isEmpty()) {
            int[] curr = nm.poll();
            int u = curr[0], d = curr[1];
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            if (u == node2)
                return d;
            for (int[] e : res.get(u)) {
                int v = e[0], w = e[1];
                if (!visited[v]) {
                    nm.offer(new int[] { v, d + w });
                }
            }
        }
        return -1;
    }
}
