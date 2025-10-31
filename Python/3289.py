from typing import Counter, List


class Solution:
    def getSneakyNumbers(self, nums: List[int]) -> List[int]:
        freq = Counter(nums)
        result = []
        for i, v in freq.items():
            if v == 2:
                result.append(i)
        return result
