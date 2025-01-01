class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int lastMax = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currMax = Math.max(currMax, i + nums[i]);
            if (i == lastMax) {
                steps++;
                lastMax = currMax;
            }
        }
        return steps;
    }
}
