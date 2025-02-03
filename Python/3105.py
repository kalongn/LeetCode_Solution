from typing import List


class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        result = ascend = descend = 1
        for i in range(len(nums) - 1):
            if nums[i] < nums[i + 1]:
                ascend += 1
                descend = 1
            elif nums[i] > nums[i + 1]:
                descend += 1
                ascend = 1
            else:
                ascend = descend = 1
            result = max(result, ascend, descend)
        return result
