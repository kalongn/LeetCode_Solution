from typing import List


class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        left, right = 1, max(nums)
        n = len(nums)

        while left < right:
            mid = left + (right - left) // 2
            thefts = 0

            index = 0
            while index < n:
                if nums[index] <= mid:
                    thefts += 1
                    index += 2
                else:
                    index += 1

            if thefts >= k:
                right = mid
            else:
                left = mid + 1

        return left
