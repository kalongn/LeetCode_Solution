from typing import List


class Solution:
    def maximumEnergy(self, energy: List[int], k: int) -> int:
        result = [0] * k
        for i, e in enumerate(energy):
            result[i % k] = max(e, result[i % k] + e)
        return max(result)
