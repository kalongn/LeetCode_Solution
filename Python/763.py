from typing import List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last = [0] * 26
        for i, c in enumerate(s):
            last[ord(c) - ord("a")] = i

        start, end = 0, 0
        result = []

        for i, c in enumerate(s):
            end = max(end, last[ord(c) - ord("a")])
            if i == end:
                result.append(i - start + 1)
                start = i + 1

        return result
