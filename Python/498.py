import collections
from typing import List


class Solution:
    def findDiagonalOrder(self, matrix: List[List[int]]) -> List[int]:
        d = collections.defaultdict(list)
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                d[i + j].append(matrix[i][j])

        result = []
        for entry in d.items():
            if entry[0] % 2 == 0:
                result.extend(entry[1][::-1])
            else:
                result.extend(entry[1])

        return result
