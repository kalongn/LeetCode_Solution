from typing import List


class Solution:
    def successfulPairs(
        self, spells: List[int], potions: List[int], success: int
    ) -> List[int]:
        potions.sort()
        n, m = len(spells), len(potions)
        result = [0] * n
        for i, spell in enumerate(spells):
            left, right = 0, m
            while left < right:
                mid = left + (right - left) // 2
                if spell * potions[mid] >= success:
                    right = mid
                else:
                    left = mid + 1
            result[i] = m - left
        return result
