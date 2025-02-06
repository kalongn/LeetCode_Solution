from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        global_max = prev_max = prev_min = nums[0]
        for i in range(1, len(nums)):
            curr_min = min(prev_max * nums[i], prev_min * nums[i], nums[i])
            curr_max = max(prev_max * nums[i], prev_min * nums[i], nums[i])
            global_max = max(global_max, curr_max)
            prev_max = curr_max
            prev_min = curr_min

        return global_max
