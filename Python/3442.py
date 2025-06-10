from typing import Counter


class Solution:
    def maxDifference(self, s: str) -> int:
        counter = Counter(s)
        max_odd = max(count for count in counter.values() if count % 2 == 1)
        min_even = min(count for count in counter.values() if count % 2 == 0)
        return max_odd - min_even
