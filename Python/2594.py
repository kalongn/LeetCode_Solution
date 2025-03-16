from typing import List


class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        def isPossible(val):
            car_fixed = 0
            for rank in ranks:
                car_fixed += int((val // rank) ** 0.5)
            return car_fixed >= cars

        left, right = 1, max(ranks) * cars**2

        result = 0
        while left <= right:
            mid = left + (right - left) // 2
            if isPossible(mid):
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        return result
