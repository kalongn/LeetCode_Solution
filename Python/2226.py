from typing import List


class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:

        def isPossible(num_candies):
            count = 0
            for pile in candies:
                count += pile // num_candies

            return count >= k

        left, right = 1, max(candies)
        result = 0
        while left <= right:
            mid = left + (right - left) // 2

            if isPossible(mid):
                result = max(result, mid)
                left = mid + 1
            else:
                right = mid - 1

        return result
