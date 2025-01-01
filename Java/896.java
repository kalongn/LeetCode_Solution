class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increase = false, decrease = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                decrease = true;
            }
            if (nums[i] > nums[i - 1]) {
                increase = true;
            }
        }
        return increase && decrease ? false : true;
    }
}
