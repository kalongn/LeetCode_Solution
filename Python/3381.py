from typing import List


class Solution:
    def maxSubarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        prefix_sum = [0] * (n + 1)
        for i, num in enumerate(nums):
            prefix_sum[i + 1] = num + prefix_sum[i]

        result = float("-inf")

        for start in range(k):
            cur_sum = 0
            for i in range(start, len(prefix_sum) - k, k):
                cur_sum = max(
                    prefix_sum[i + k] - prefix_sum[i],
                    cur_sum + prefix_sum[i + k] - prefix_sum[i],
                )
                result = max(result, cur_sum)

        return result
