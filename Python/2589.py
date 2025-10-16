from collections import defaultdict
from typing import List


class Solution:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        num_group = defaultdict(int)
        for num in nums:
            num_group[num % value] += 1

        mex = 0
        while num_group[mex % value] > 0:
            num_group[mex % value] -= 1
            mex += 1
        return mex
