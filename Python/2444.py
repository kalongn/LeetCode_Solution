from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        result = 0
        subarr_start_index = prev_min_index = prev_max_index = -1

        for i, num in enumerate(nums):
            if num < minK or num > maxK:
                subarr_start_index = i
            if num == minK:
                prev_min_index = i
            if num == maxK:
                prev_max_index = i

            result += max(0, min(prev_min_index, prev_max_index) - subarr_start_index)

        return result
