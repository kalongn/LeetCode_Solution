class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];

        int i = 0;
        for (int day = 1; day <= lastDay; day++) {
            if (day < days[i]) {
                dp[day] = dp[day - 1];
            } else {
                i++;
                dp[day] = Math.min(dp[day - 1] + costs[0],
                        Math.min(dp[Math.max(0, day - 7)] + costs[1],
                                dp[Math.max(0, day - 30)] + costs[2]));
            }
        }

        return dp[lastDay];

        // Arrays.fill(dp, -1);
        // return helper(days, costs, 0, dp);
    }

    private int helper(int[] days, int[] costs, int index, int[] dp) {
        if (index == days.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int currentDay = days[index];
        int oneIndex = index + 1;
        int sevenIndex = oneIndex;
        while (sevenIndex < days.length && days[sevenIndex] < currentDay + 7) {
            sevenIndex++;
        }
        int thirtyIndex = sevenIndex;
        while (thirtyIndex < days.length && days[thirtyIndex] < currentDay + 30) {
            thirtyIndex++;
        }
        int oneCost = costs[0] + helper(days, costs, oneIndex, dp);
        int sevenCost = costs[1] + helper(days, costs, sevenIndex, dp);
        int thirtyCost = costs[2] + helper(days, costs, thirtyIndex, dp);
        dp[index] = Math.min(oneCost, Math.min(sevenCost, thirtyCost));
        return dp[index];
    }
}