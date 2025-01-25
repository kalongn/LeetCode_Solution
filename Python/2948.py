from collections import deque
from typing import List


class Solution:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        groups = []
        nums_map = dict()

        for n in sorted(nums):
            if not groups or abs(n - groups[-1][-1]) > limit:
                groups.append(deque())

            groups[-1].append(n)
            nums_map[n] = len(groups) - 1

        result = []
        for n in nums:
            j = nums_map[n]
            result.append(groups[j].popleft())

        return result
