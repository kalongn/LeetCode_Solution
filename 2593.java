import java.util.*;
import javafx.util.Pair;

class Solution {
    public long findScore(int[] nums) {
        boolean[] marked = new boolean[nums.length];
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(
                (x, y) -> Integer.compare(x.getKey(), y.getKey()) == 0 ? Integer.compare(x.getValue(), y.getValue())
                        : Integer.compare(x.getKey(), y.getKey()));
        for (int i = 0; i < nums.length; i++) {
            heap.offer(new Pair<Integer, Integer>(nums[i], i));
        }

        long score = 0;
        while (!heap.isEmpty()) {
            Pair<Integer, Integer> polled = heap.poll();
            int index = polled.getValue();
            if (marked[index]) {
                continue;
            }
            score += polled.getKey();
            marked[index] = true;
            int leftIndex = index - 1;
            if (leftIndex >= 0 && !marked[leftIndex]) {
                marked[leftIndex] = true;
            }
            int rightIndex = index + 1;
            if (rightIndex < nums.length && !marked[rightIndex]) {
                marked[rightIndex] = true;
            }
        }
        return score;
    }
}