import java.util.*;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);
        for (int i : gifts) {
            heap.add(i);
        }
        for (int i = 0; i < k; i++) {
            int polled = (int) Math.floor(Math.sqrt(heap.poll()));
            heap.add(polled);
        }
        long sum = 0;
        while (!heap.isEmpty()) {
            sum += heap.poll();
        }
        return sum;
    }
}