class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int min = Integer.MAX_VALUE;
        int maxProfit = -1;
        int indProfit = 0;
        for (int i = 0; i < length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            indProfit = prices[i] - min;
            if (maxProfit < indProfit) {
                maxProfit = indProfit;
            }
        }
        return maxProfit;
    }
}
