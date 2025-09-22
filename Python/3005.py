from typing import Counter, List


class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        freq = Counter(nums)
        max_freq = max(f for f in freq.values())
        return sum(max_freq if f == max_freq else 0 for f in freq.values())
