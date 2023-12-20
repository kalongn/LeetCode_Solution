import java.util.Arrays;

class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int price = money - prices[0] - prices[1];
        return price >= 0 ? price : money;
    }
}
