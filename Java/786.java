import java.util.*;

class Solution {
    static class Pair implements Comparable<Pair> {
        double frc;
        int i, j;

        public Pair(double frc, int i, int j) {
            this.frc = frc;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Pair p2) {
            return Double.compare(this.frc, p2.frc);
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int ans[] = new int[2];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                pq.add(new Pair((double) arr[i] / arr[j], i, j));
            }
        }
        for (int i = 0; i < k - 1; i++) {
            pq.remove();
        }
        Pair p = pq.remove();
        ans[0] = arr[p.i];
        ans[1] = arr[p.j];
        return ans;
    }
}