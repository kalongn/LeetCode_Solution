from typing import List


class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        result = 0
        for pattern in [[0, 0], [0, 1], [1, 0], [1, 1]]:
            count = 0
            for num in nums:
                if num % 2 == pattern[count % 2]:
                    count += 1
            result = max(result, count)
        return result
