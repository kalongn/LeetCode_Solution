from typing import List


class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        dp = [0] * 3
        for num in nums:
            prev_0, prev_1, prev_2 = dp[0] + num, dp[1] + num, dp[2] + num
            dp[prev_0 % 3] = max(dp[prev_0 % 3], prev_0)
            dp[prev_1 % 3] = max(dp[prev_1 % 3], prev_1)
            dp[prev_2 % 3] = max(dp[prev_2 % 3], prev_2)

        return dp[0]
