class Solution {
    public class DSU {
        private int[] par;
        private int[] rank;

        public DSU(int n) {
            par = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                par[i] = i;
        }

        public int find(int u) {
            if (u == par[u])
                return u;
            return par[u] = find(par[u]);
        }

        public void connect(int u, int v) {
            u = find(u);
            v = find(v);
            if (rank[u] > rank[v])
                par[v] = u;
            else if (rank[u] < rank[v])
                par[u] = v;
            else {
                rank[v]++;
                par[u] = v;
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        DSU d = new DSU(n + 1);
        for (var e : roads)
            d.connect(e[0], e[1]);

        int leader = d.find(1);

        // Filter edges & update minimum edge weight
        int res = 100000;
        for (var e : roads) {
            int u = d.find(e[0]), v = d.find(e[1]);
            if (u == leader || v == leader)
                res = Math.min(res, e[2]);
        }

        return res;
    }
}
