from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        n = len(candidates)

        def dfs(cur_combination, cur_sum, index):
            if cur_sum > target:
                return

            if cur_sum == target:
                result.append(cur_combination)

            for i in range(index, n):
                dfs(cur_combination + [candidates[i]], cur_sum + candidates[i], i)

        dfs([], 0, 0)
        return result
