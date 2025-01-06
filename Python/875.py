import math
from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:

        def hours_required(k):
            total = 0
            for pile in piles:
                total += math.ceil(float(pile) / k)
            return total

        left, right = 1, max(piles)
        result = right
        while left <= right:
            mid = left + (right - left) // 2
            require = hours_required(mid)
            if require <= h:
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        return result
