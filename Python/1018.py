from typing import List


class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        result = []
        curr = 0
        for num in nums:
            curr = ((curr << 1) + num) % 5
            result.append(curr == 0)
        return result
