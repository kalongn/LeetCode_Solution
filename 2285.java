import java.util.*;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] count = new long[n];
        for (int i = 0; i < roads.length; i++) {
            count[roads[i][0]]++;
            count[roads[i][1]]++;
        }

        Arrays.sort(count);

        long value = 1;
        long result = 0;
        for (long d : count) {
            result += (value * d);
            value++;
        }
        return result;
    }
}
