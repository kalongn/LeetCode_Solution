from typing import Counter


class Solution:
    def canConstruct(self, s: str, k: int) -> bool:
        freq = Counter(s)

        amt_odd = sum(1 for count in freq.values() if count % 2 == 1)

        return amt_odd <= k and len(s) >= k
