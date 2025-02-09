from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)

        top, bottom = 0, n - 1

        while top < bottom:
            for j in range(n):
                matrix[top][j], matrix[bottom][j] = matrix[bottom][j], matrix[top][j]
            top += 1
            bottom -= 1

        for i in range(n):
            for j in range(i + 1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
