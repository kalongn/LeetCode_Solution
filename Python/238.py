from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = [0] * len(nums)

        curr = 1
        for i, num in enumerate(nums):
            result[i] = curr
            curr *= num

        curr = 1
        for i, num in reversed(list(enumerate(nums))):
            result[i] *= curr
            curr *= nums[i]

        return result
