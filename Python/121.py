from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        result = 0
        cur_min = prices[0]

        for i in range(len(prices)):
            if prices[i] < cur_min:
                cur_min = prices[i]
            result = max(result, prices[i] - cur_min)

        return result
