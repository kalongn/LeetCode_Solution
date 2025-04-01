from functools import cache
from typing import List


class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        @cache
        def helper(i):
            if i >= len(questions):
                return 0

            points, jump = questions[i][0], questions[i][1]

            return max(helper(i + 1), points + helper(i + jump + 1))

        return helper(0)
