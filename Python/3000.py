from math import sqrt
from typing import List


class Solution:
    def areaOfMaxDiagonal(self, dimensions: List[List[int]]) -> int:
        max_rec = -1
        max_area = -1
        for pair in dimensions:
            dial = sqrt(pair[0] ** 2 + pair[1] ** 2)
            area = pair[0] * pair[1]
            if dial > max_rec:
                max_rec = dial
                max_area = area
            elif dial == max_rec:
                max_area = max(max_area, area)
        return max_area
