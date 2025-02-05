from typing import List


class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        nearest_left = [-1] * len(s)
        prefix = [0] * len(s)

        bar_count, prev = 0, -1
        for i in range(len(s)):
            if s[i] == "|":
                prev = i
                bar_count += 1
            nearest_left[i] = prev
            prefix[i] = bar_count

        prev = -1
        nearest_right = [-1] * len(s)
        for i in range(len(s) - 1, -1, -1):
            if s[i] == "|":
                prev = i
            nearest_right[i] = prev

        result = [0] * len(queries)

        for i, (left, right) in enumerate(queries):
            left = nearest_right[left]
            right = nearest_left[right]

            if left != -1 and right != 1 and left < right:
                result[i] = right - left - (prefix[right] - prefix[left])

        return result
