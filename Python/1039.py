from typing import List


class Solution:
    def minScoreTriangulation(self, values: List[int]) -> int:
        n = len(values)
        dp = [[0] * n for _ in range(n)]
        for start in reversed(range(n)):
            for end in range(start + 2, n):
                score = float("inf")
                for k in range(start + 1, end):
                    score = min(
                        score,
                        values[start] * values[k] * values[end]
                        + dp[start][k]
                        + dp[k][end],
                    )
                dp[start][end] = score
        return dp[0][n - 1]
