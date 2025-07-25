from typing import List


class Solution:
    def maxSum(self, nums: List[int]) -> int:
        positiveNum = set([num for num in nums if num > 0])
        return sum(positiveNum) if len(positiveNum) != 0 else max(nums)
