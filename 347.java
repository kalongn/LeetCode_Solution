import java.util.*;
import javafx.util.Pair;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        Queue<Pair<Integer, Integer>> heap = new PriorityQueue<>((x, y) -> Integer.compare(x.getValue(), y.getValue()));
        for (Map.Entry<Integer, Integer> pair : count.entrySet()) {
            heap.add(new Pair<Integer, Integer>(pair.getKey(), pair.getValue()));
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().getKey();
        }
        return result;
    }
}