import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}
