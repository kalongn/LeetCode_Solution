from typing import List


class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        result = 0
        for fruit in fruits:
            is_set = True
            for i, basket in enumerate(baskets):
                if fruit <= basket:
                    baskets[i] = 0
                    is_set = False
                    break
            result += 1 if is_set else 0
        return result
