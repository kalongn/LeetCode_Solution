import java.util.*;

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (x, y) -> Integer.compare(x[0], y[0]) == 0 ? Integer.compare(x[1], y[1]) : Integer.compare(x[0], y[0]));

        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[] { nums[i], i });
        }

        for (int i = 0; i < k; i++) {
            int[] minPair = heap.poll();
            minPair[0] *= multiplier;
            heap.offer(minPair);
        }

        while (!heap.isEmpty()) {
            int[] pair = heap.poll();
            nums[pair[1]] = pair[0];
        }
        return nums;
    }
}