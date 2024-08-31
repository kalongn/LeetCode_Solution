import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0], b = edges[i][1];
            g.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[] { b, i });
            g.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[] { a, i });
        }
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(start));
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] a : g.getOrDefault(cur, Collections.emptyList())) {
                int neighbor = a[0], index = a[1];
                if (maxProb[cur] * succProb[index] > maxProb[neighbor]) {
                    maxProb[neighbor] = maxProb[cur] * succProb[index];
                    queue.offer(neighbor);
                }
            }
        }
        return maxProb[end];
    }
}