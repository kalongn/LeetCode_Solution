import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int a : stones) {
            heap.offer(a);
        }
        while (heap.size() > 1) {
            heap.offer(heap.poll() - heap.poll());
        }
        return heap.poll();
    }
}