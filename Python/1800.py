from typing import List


class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        result = increase = nums[0]
        for i in range(len(nums) - 1):
            if nums[i] < nums[i + 1]:
                increase += nums[i + 1]
            else:
                increase = nums[i + 1]
            result = max(result, increase)

        return result
