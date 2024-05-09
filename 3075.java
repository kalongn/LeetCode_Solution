import java.util.PriorityQueue;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int h : happiness) {
            pq.add(h);
        }

        long result = 0;
        int turns = 0;

        for (int i = 0; i < k; i++) {
            result += Math.max(pq.poll() - turns, 0);
            turns++;
        }
        return result;
    }
}
