from typing import Counter, List


class Solution:
    def findLucky(self, arr: List[int]) -> int:
        freq = Counter(arr)
        result = -1
        for num, count in freq.items():
            if num == count:
                result = max(result, num)

        return result
