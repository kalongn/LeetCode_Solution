from typing import List


class NumMatrix:
    def __init__(self, matrix: List[List[int]]):
        self.rows, self.cols = len(matrix), len(matrix[0])
        self.prefix_sum = [[0] * (self.cols + 1) for _ in range(self.rows + 1)]

        for i in range(self.rows):
            for j in range(self.cols):
                self.prefix_sum[i + 1][j + 1] = (
                    matrix[i][j]
                    + self.prefix_sum[i][j + 1]
                    + self.prefix_sum[i + 1][j]
                    - self.prefix_sum[i][j]
                )

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        return (
            self.prefix_sum[row2 + 1][col2 + 1]
            - self.prefix_sum[row1][col2 + 1]
            - self.prefix_sum[row2 + 1][col1]
            + self.prefix_sum[row1][col1]
        )
