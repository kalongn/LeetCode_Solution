from typing import List


class Solution:
    def hasIncreasingSubarrays(self, nums: List[int], k: int) -> bool:
        prev_length, cur_length = 0, 1
        result = 0

        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                cur_length += 1
            else:
                prev_length = cur_length
                cur_length = 1
            result = max(result, cur_length // 2, min(prev_length, cur_length))

        return result >= k
