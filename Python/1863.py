from typing import List


class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:

        def backtracking(i, curr_xor):
            if i == len(nums):
                return curr_xor

            include = backtracking(i + 1, curr_xor ^ nums[i])
            exclude = backtracking(i + 1, curr_xor)

            return include + exclude

        return backtracking(0, 0)
