import java.util.*;

class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long prevSum = 0, result = -1;
        for (int num : nums) {
            if (num < prevSum) {
                result = num + prevSum;
            }
            prevSum += num;
        }
        return result;
    }
}
