from bisect import bisect_left, bisect_right
from typing import Counter, List


class Solution:
    def maxFrequency(self, nums: List[int], k: int, numOperations: int) -> int:
        nums.sort()
        result = 0
        freq = Counter(nums)

        for i in range(nums[0], nums[-1] + 1):
            left = bisect_left(nums, i - k)
            right = bisect_right(nums, i + k)
            result = max(result, min(right - left, freq[i] + numOperations))

        return result
