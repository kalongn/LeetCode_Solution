import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        int last = 1;
        for (int i = 0; i < n; i++) {
            result[i] *= last;
            last *= nums[i];
        }
        last = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= last;
            last *= nums[i];
        }
        return result;
    }
}