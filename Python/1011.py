from typing import List


class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:

        def feasible(weight):
            day = 0
            cur_weight = 0
            for i in weights:
                if cur_weight + i <= weight:
                    cur_weight += i
                else:
                    day += 1
                    cur_weight = i
            if cur_weight != 0:
                day += 1
            return day if day != 0 else 1

        left, right = max(weights), sum(weights)
        result = right
        while left <= right:
            mid = left + (right - left) // 2
            if feasible(mid) <= days:
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        return result
