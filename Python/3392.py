from typing import List


class Solution:
    def countSubarrays(self, nums: List[int]) -> int:
        n = len(nums)
        result = 0
        for i in range(1, n - 1):
            if nums[i] == (nums[i - 1] + nums[i + 1]) * 2:
                result += 1
        return result
