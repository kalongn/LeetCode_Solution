class Solution {
    public boolean canSortArray(int[] nums) {
        int prevGroupHigh = 0;
        int high = nums[0];
        boolean bitChange = false;

        for (int i : nums) {
            bitChange = Integer.bitCount(high) != Integer.bitCount(i);
            if (bitChange) {
                prevGroupHigh = high;
            }
            if (i > high) {
                high = i;
            }
            if (i < prevGroupHigh) {
                return false;
            }
        }

        return true;
    }
}