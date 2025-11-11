from typing import Counter, List


class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        counters = [Counter(s) for s in strs]

        for freq in counters:
            zeros, ones = freq.get("0", 0), freq.get("1", 0)
            for i in range(m, zeros - 1, -1):
                for j in range(n, ones - 1, -1):
                    dp[i][j] = max(dp[i][j], 1 + dp[i - zeros][j - ones])

        return dp[-1][-1]
