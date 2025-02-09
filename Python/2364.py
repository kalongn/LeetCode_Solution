from collections import defaultdict
from typing import List


class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        bad_pairs = 0
        diffs = defaultdict(int)

        for j in range(len(nums)):
            diff = j - nums[j]
            good_pairs = diffs[diff]
            bad_pairs += j - good_pairs
            diffs[diff] += 1

        return bad_pairs
