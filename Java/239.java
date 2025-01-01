import java.util.*;
import javafx.util.Pair;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((x, y) -> y.getKey() - x.getKey());

        int resultIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            heap.offer(new Pair<Integer, Integer>(nums[i], i));
            if (i >= k - 1) {
                while (heap.peek().getValue() <= i - k) {
                    heap.poll();
                }
                result[resultIndex] = heap.peek().getKey();
                resultIndex++;
            }
        }

        return result;
    }
}