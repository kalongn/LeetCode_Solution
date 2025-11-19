from typing import List


class Solution:
    def findFinalValue(self, nums: List[int], original: int) -> int:
        all_nums = set(nums)
        while original in all_nums:
            original *= 2
        return original
