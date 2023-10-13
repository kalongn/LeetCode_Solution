class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0], second = cost[1];
        if (n <= 2) {
            return Math.min(first, second);
        }
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }
        return Math.min(first, second);
    }
}
