from collections import deque
from typing import List


class Solution:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        rows, cols = len(isWater), len(isWater[0])
        queue = deque()  # (x, y)
        result = [[-1] * cols for _ in range(rows)]  # -1 == not visited

        for i in range(rows):
            for j in range(cols):
                if isWater[i][j]:
                    queue.append((i, j))
                    result[i][j] = 0

        while queue:
            row, col = queue.popleft()
            height = result[row][col]
            neightors = [(row + 1, col), (row, col + 1), (row - 1, col), (row, col - 1)]
            for nx, ny in neightors:
                if nx < 0 or ny < 0 or nx == rows or ny == cols or result[nx][ny] != -1:
                    continue

                queue.append((nx, ny))
                result[nx][ny] = height + 1

        return result
