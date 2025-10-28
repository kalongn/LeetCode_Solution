from typing import List


class Solution:
    def countValidSelections(self, nums: List[int]) -> int:
        n = len(nums)
        result = 0
        total = sum(nums)

        left, right = 0, total
        for i in range(n):
            if nums[i] == 0:
                if 0 <= left - right <= 1:
                    result += 1
                if 0 <= right - left <= 1:
                    result += 1
            else:
                left += nums[i]
                right -= nums[i]

        return result
