from typing import List


class Solution:
    def minNumberOperations(self, target: List[int]) -> int:
        result = target[0]
        for i in range(1, len(target)):
            result += max(target[i] - target[i - 1], 0)
        return result
