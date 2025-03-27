from collections import defaultdict
from typing import List


class Solution:
    def minimumIndex(self, nums: List[int]) -> int:
        split_one, split_two = defaultdict(int), defaultdict(int)
        n = len(nums)

        for num in nums:
            split_two[num] += 1

        for i in range(n):
            num = nums[i]

            split_one[num] += 1
            split_two[num] -= 1

            if split_one[num] * 2 > i + 1 and split_two[num] * 2 > n - i - 1:
                return i

        return -1
