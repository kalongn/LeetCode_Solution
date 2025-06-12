from typing import List


class Solution:
    def maxAdjacentDistance(self, nums: List[int]) -> int:
        n = len(nums)
        result = abs(nums[0] - nums[n - 1])
        for i in range(n - 1):
            result = max(result, abs(nums[i] - nums[i + 1]))
        return result
