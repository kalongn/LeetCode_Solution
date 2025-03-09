from typing import List


class Solution:
    def numberOfAlternatingGroups(self, colors: List[int], k: int) -> int:
        colors = colors + colors[: k - 1]
        length = len(colors)
        result = 0
        left, right = 0, 1

        while right < length:
            if colors[right] == colors[right - 1]:
                left = right
                right += 1
                continue

            right += 1

            if right - left < k:
                continue

            result += 1
            left += 1

        return result
