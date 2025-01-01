import java.util.*;
import javafx.util.Pair;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char i : tasks) {
            freq[i - 'A']++;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);
        for (int i : freq) {
            if (i > 0) {
                heap.offer(i);
            }
        }
        int time = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        while (!heap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (heap.isEmpty()) {
                time = queue.peek().getValue();
            } else {
                int jobLeft = heap.poll() - 1;
                if (jobLeft > 0) {
                    queue.offer(new Pair<Integer, Integer>(jobLeft, time + n));
                }
            }

            if (!queue.isEmpty() && time == queue.peek().getValue()) {
                heap.offer(queue.poll().getKey());
            }
        }
        return time;
    }
}