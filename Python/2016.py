from typing import List


class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
        n = len(nums)
        result, pre_min = -1, nums[0]

        for i in range(1, n):
            if nums[i] > pre_min:
                result = max(result, nums[i] - pre_min)
            else:
                pre_min = nums[i]

        return result
