import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);
        for (int i : stones) {
            heap.offer(i);
        }
        while (heap.size() > 1) {
            int result = heap.poll() - heap.poll();
            if (result != 0) {
                heap.offer(result);
            }
        }
        return heap.size() == 0 ? 0 : heap.peek();
    }
}