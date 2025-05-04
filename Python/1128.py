from typing import List


class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        num_count = [0] * 100
        result = 0

        for x, y in dominoes:
            num = x * 10 + y if x <= y else y * 10 + x
            result += num_count[num]
            num_count[num] += 1

        return result
