import java.util.Arrays;

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] order = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            order[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(order);
        int result = 0;
        for (int i = 0; i < order.length; i++) {
            if (order[i] <= i) {
                break;
            }
            result++;
        }
        return result;
    }
}
