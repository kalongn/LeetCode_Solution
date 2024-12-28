import java.util.*;
import javafx.util.*;

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int amtOfSub = nums.length - k + 1;

        int[] sums = new int[amtOfSub];
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        sums[0] = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            sums[i - k + 1] = windowSum;
        }

        Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();

        int i = 0;
        int[] index = new int[3];
        int count = 0;
        while (i <= nums.length - k && count < 3) {
            int include = sums[i] + getMaxSum(i + k, count + 1, nums, k, sums, memo);
            int skip = getMaxSum(i + 1, count, nums, k, sums, memo);
            if (include >= skip) {
                index[count] = i;
                count++;
                i += k;
            } else {
                i++;
            }
        }

        return index;
    }

    private int getMaxSum(int index, int count, int[] nums, int k, int[] sums,
            Map<Pair<Integer, Integer>, Integer> memo) {
        if (index > nums.length - k || count == 3) {
            return 0;
        }
        Pair<Integer, Integer> current = new Pair<>(index, count);
        if (memo.containsKey(current)) {
            return memo.get(current);
        }

        int include = sums[index] + getMaxSum(index + k, count + 1, nums, k, sums, memo);
        int skip = getMaxSum(index + 1, count, nums, k, sums, memo);
        memo.put(current, Math.max(include, skip));
        return memo.get(current);
    }
}