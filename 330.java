class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0, i = 0;
        long priorSum = 0;
        while (priorSum < n) {
            if (i >= nums.length || nums[i] > priorSum + 1) {
                ++count;
                priorSum = (priorSum << 1) + 1;
            } else
                priorSum += nums[i++];
        }
        return count;
    }
}