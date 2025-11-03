from typing import List


class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        result = cur_max = 0
        for i in range(len(colors)):
            if i > 0 and colors[i] != colors[i - 1]:
                cur_max = 0
            result += min(cur_max, neededTime[i])
            cur_max = max(cur_max, neededTime[i])
        return result
