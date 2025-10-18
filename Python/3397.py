import math
from typing import List


class Solution:
    def maxDistinctElements(self, nums: List[int], k: int) -> int:
        nums.sort()
        result = 0
        prev = math.inf

        for i in range(len(nums) - 1, -1, -1):
            curr = max(min(nums[i] + k, prev - 1), nums[i] - k)
            if curr < prev:
                result += 1
                prev = curr

        return result
