import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (int i : s.toCharArray()) {
            freq[i - 'a']++;
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> Integer.compare(y[1], x[1]));
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                heap.offer(new int[] { freq[i], i + 'a' });
            }
        }
        StringBuilder result = new StringBuilder(s.length());
        while (!heap.isEmpty()) {
            int[] highLex = heap.poll();
            for (int i = 0; i < Math.min(highLex[0], repeatLimit); i++) {
                result.append((char) highLex[1]);
            }
            if (highLex[0] - repeatLimit > 0) {
                highLex[0] -= repeatLimit;
                if (!heap.isEmpty()) {
                    int[] nextLex = heap.poll();
                    result.append((char) nextLex[1]);
                    nextLex[0]--;
                    if (nextLex[0] != 0) {
                        heap.offer(nextLex);
                    }
                    heap.offer(highLex);
                }
            }
        }
        return result.toString();
    }
}