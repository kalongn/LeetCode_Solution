from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        result = cur_sum = nums[0]
        for i in range(1, len(nums)):
            cur_sum = max(cur_sum + nums[i], nums[i])
            result = max(result, cur_sum)
        return result
