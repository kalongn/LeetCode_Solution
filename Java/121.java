class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] > prices[i + 1]) {
                continue;
            }
            int win = i + 1;
            while (win < prices.length && prices[i] <= prices[win]) {
                result = Math.max(result, prices[win] - prices[i]);
                win++;
            }
            i = win - 1;
        }
        return result;
    }
}