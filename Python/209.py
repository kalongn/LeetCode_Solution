from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        min_result = float("inf")
        left = 0
        cur_sum = 0
        for right in range(len(nums)):
            cur_sum += nums[right]
            while cur_sum >= target:
                min_result = min(min_result, right - left + 1)
                cur_sum -= nums[left]
                left += 1

        return 0 if min_result == float("inf") else min_result
