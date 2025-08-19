from typing import List


class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        total = current = 0

        for num in nums:
            if num == 0:
                current += 1
                total += current
            else:
                current = 0

        return total
