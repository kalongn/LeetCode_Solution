from typing import List


class Solution:
    def maxIncreasingSubarrays(self, nums: List[int]) -> int:
        prev_length, cur_length = 0, 1
        result = 0
        for i in range(1, len(nums)):
            if nums[i - 1] < nums[i]:
                cur_length += 1
            else:
                prev_length = cur_length
                cur_length = 1
            result = max(result, cur_length // 2, min(prev_length, cur_length))
        return result
