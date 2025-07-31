from typing import List


class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        result = set()
        current = {0}
        for x in arr:
            current = {x | y for y in current} | {x}
            result |= current
        return len(result)
