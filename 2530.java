import java.util.*;

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums) {
            heap.offer(i);
        }
        long sum = 0;
        for (int i = 0; i < k && !heap.isEmpty(); i++) {
            int currentVal = heap.poll();
            sum += currentVal;
            heap.offer((int) Math.ceil(currentVal / 3.0));
        }
        return sum;
    }
}
