from typing import List


class Solution:
    def buildArray(self, nums: List[int]) -> List[int]:
        result = [0] * len(nums)
        for i, num in enumerate(nums):
            result[i] = nums[num]
        return result
