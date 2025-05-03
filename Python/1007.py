from typing import List


class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        def check(candidate, row1, row2):
            rotations = 0
            for i, j in zip(row1, row2):
                if i == candidate:
                    continue
                if j == candidate:
                    rotations += 1
                else:
                    return float("inf")
            return rotations

        candidates = {tops[0], bottoms[0]}
        n = len(tops)
        result = float("inf")

        for candidate in candidates:
            result = min(
                result, check(candidate, tops, bottoms), check(candidate, bottoms, tops)
            )

        return result if result != float("inf") else -1
