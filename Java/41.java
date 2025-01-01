class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean seenOne = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                seenOne = true;
            }
            if (nums[i] < 1 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        if (!seenOne) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            int current = Math.abs(nums[i]);
            if (current == n) {
                nums[0] = -(Math.abs(nums[0]));
            } else {
                nums[current] = -(Math.abs(nums[current]));
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return n;
        }

        return n + 1;
    }
}
