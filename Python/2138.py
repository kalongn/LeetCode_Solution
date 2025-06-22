from typing import List


class Solution:
    def divideString(self, s: str, k: int, fill: str) -> List[str]:
        chunks = [s[i : i + k] for i in range(0, len(s), k)]
        chunks[-1] = chunks[-1].ljust(k, fill)
        return chunks
