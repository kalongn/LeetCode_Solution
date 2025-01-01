class Solution {
    // j = point at the item that is not a 0.
    // i = index iterating.
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                j = i + 1;
            result += i - j + 1;
        }
        return result;
    }
}
