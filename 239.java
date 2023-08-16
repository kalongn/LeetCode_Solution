import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // assume nums is not null
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1]; // number of windows
        Deque<Integer> win = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; ++i) {
            // remove indices that are out of bound
            while (win.size() > 0 && win.peekFirst() <= i - k) {
                win.pollFirst();
            }
            // remove indices whose corresponding values are less than nums[i]
            while (win.size() > 0 && nums[win.peekLast()] < nums[i]) {
                win.pollLast();
            }
            // add nums[i]
            win.offerLast(i);
            // add to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[win.peekFirst()];
            }
        }
        return result;
    }
    /*public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= k) {
            return new int[] { Arrays.stream(nums).max().getAsInt() };
        }
        int[] result = new int[nums.length - k + 1];
        int[] window = new int[k];
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.stream(window).max().getAsInt();
            if (i + k < nums.length) {
                window[i % k] = nums[i + k];
            }
        }
        return result;
    }*/
}
