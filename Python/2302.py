from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        n = len(nums)
        result, total = 0, 0
        left = 0
        for right in range(n):
            total += nums[right]
            while left <= right and total * (right - left + 1) >= k:
                total -= nums[left]
                left += 1
            result += right - left + 1
        return result
