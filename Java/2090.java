import java.util.Arrays;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] avgs = new int[nums.length];
        Arrays.fill(avgs, -1);

        if (2 * k + 1 > nums.length) {
            return avgs;
        }

        long sum = 0;
        for (int i = 0; i < 2 * k + 1; i++) {
            sum += nums[i];
        }

        long avg = sum / (2 * k + 1);
        avgs[k] = (int) avg;

        for (int i = 2 * k + 1, c = 0; i < nums.length; i++, c++) {
            sum += nums[i];
            sum -= nums[c];
            avg = sum / (2 * k + 1);
            avgs[k + c + 1] = (int) avg;
        }
        return avgs;
    }
}