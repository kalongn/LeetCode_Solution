import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int size = graph.length;
        int target = (1 << size) - 1;
        boolean[][] visited = new boolean[size][target];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < size; ++i) {
            queue.offer(new int[] { i, 1 << i });
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; ++i) {
                int[] cur = queue.poll();
                int node = cur[0];
                int state = cur[1];
                if (state == target) {
                    return step;
                }
                if (visited[node][state]) {
                    continue;
                }
                visited[node][state] = true;
                for (int next : graph[node]) {
                    queue.offer(new int[] { next, state | (1 << next) });
                }
            }
            step++;
        }
        return -1;
    }
}
