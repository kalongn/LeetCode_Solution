from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        n = len(nums)

        def dfs(cur_permutation):
            if len(cur_permutation) == n:
                result.append(cur_permutation)
                return

            for i in range(n):
                if nums[i] not in cur_permutation:
                    dfs(cur_permutation + [nums[i]])

        dfs([])
        return result
