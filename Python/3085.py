from collections import defaultdict


class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        counter = defaultdict(int)
        for c in word:
            counter[c] += 1
        result = len(word)
        for a in counter.values():
            deleted = 0
            for b in counter.values():
                if a > b:
                    deleted += b
                elif b > a + k:
                    deleted += b - (a + k)
            result = min(result, deleted)
        return result
