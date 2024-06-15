import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        final int N = profits.length;
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        int i = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        while (k-- > 0) {
            while (i < N && arr[i][1] <= w) {
                maxHeap.offer(arr[i][0]);
                i++;
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll();
        }
        return w;
    }
}
