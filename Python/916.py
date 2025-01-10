from typing import List


class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        def count(word):
            result = [0] * 26
            for c in word:
                result[ord(c) - ord("a")] += 1
            return result

        b_combine = [0] * 26
        for b in words2:
            for i, c in enumerate(count(b)):
                b_combine[i] = max(b_combine[i], c)

        result = []
        for a in words1:
            if all(x >= y for x, y in zip(count(a), b_combine)):
                result.append(a)

        return result
