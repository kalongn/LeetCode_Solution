from collections import Counter
from typing import List


class Solution:
    def maximumTotalDamage(self, power: List[int]) -> int:
        freq = Counter(power)
        strength = {power: power * freq[power] for power in freq}
        spells = [0, 0, 0] + sorted(list(strength.keys()))
        n = len(spells)
        dp = [0] * n

        for i in range(3, n):
            if spells[i] - spells[i - 1] > 2:
                dp[i] = dp[i - 1] + strength[spells[i]]
            elif spells[i] - spells[i - 2] > 2:
                dp[i] = max(dp[i - 1], dp[i - 2] + strength[spells[i]])
            else:
                dp[i] = max(dp[i - 1], dp[i - 3] + strength[spells[i]])

        return dp[-1]
