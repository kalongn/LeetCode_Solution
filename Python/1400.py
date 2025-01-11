from typing import Counter


class Solution:
    def canConstruct(self, s: str, k: int) -> bool:
        return (
            len(s) >= k
            and sum(1 for count in Counter(s).values() if count % 2 == 1) <= k
        )
