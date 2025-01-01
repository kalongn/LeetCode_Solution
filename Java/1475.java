import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];

        stack.push(prices[n - 1]);
        result[n - 1] = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = prices[i];
            } else {
                result[i] = prices[i] - stack.peek();
            }
            stack.push(prices[i]);
        }
        return result;
    }
}