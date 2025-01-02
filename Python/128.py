from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        result = 0
        numSet = set(nums)
        for num in numSet:
            if num - 1 not in numSet:
                length = 1
                while num + length in numSet:
                    length += 1
                result = max(result, length)

        return result
