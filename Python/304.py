from typing import List


class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        rows, cols = len(matrix), len(matrix[0])
        self.prefix_sum = [[0] * (cols + 1) for _ in range(rows + 1)]

        for i in range(rows):
            prefix = 0
            for j in range(cols):
                prefix += matrix[i][j]
                self.prefix_sum[i + 1][j + 1] = prefix + self.prefix_sum[i][j + 1]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        row1, col1, row2, col2 = row1 + 1, col1 + 1, row2 + 1, col2 + 1
        above = self.prefix_sum[row1 - 1][col2]
        side = self.prefix_sum[row2][col1 - 1]
        center = self.prefix_sum[row1 - 1][col1 - 1]
        return self.prefix_sum[row2][col2] - above - side + center
