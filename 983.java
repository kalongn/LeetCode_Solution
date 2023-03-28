class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        return minCostTickets(days, costs, 0, dp);
    }

    public static int minCostTickets(int[] days, int[] costs, int day, int[] dp) {
        if (day >= days.length)
            return 0;
        // return previously calculated day
        if (dp[day] != 0)
            return dp[day];
        int i;

        // Attempt to buy a one-day ticket
        int buyOneDay = minCostTickets(days, costs, day + 1, dp) + costs[0];

        // Attempt to buy a seven-day ticket and skip all days that will be included in
        // this ticket
        for (i = day; i < days.length; i++)
            if (days[i] >= days[day] + 7)
                break;
        int buySevenDays = minCostTickets(days, costs, i, dp) + costs[1];

        // Attempt to buy a thirty-day ticket and skip all days that will be included in
        // this ticket
        for (i = day; i < days.length; i++)
            if (days[i] >= days[day] + 30)
                break;
        int buyThirtyDays = minCostTickets(days, costs, i, dp) + costs[2];

        // return minimum of three options
        int result = Math.min(Math.min(buyOneDay, buySevenDays), buyThirtyDays);
        dp[day] = result;
        return result;

    }
}
