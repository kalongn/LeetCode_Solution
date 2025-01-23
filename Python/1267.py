from typing import List


class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        result = 0
        n, m = len(grid), len(grid[0])
        rows = [0] * n
        cols = [0] * m

        for row in range(n):
            for col in range(m):
                if grid[row][col] == 1:
                    rows[row] += 1
                    cols[col] += 1

        for row in range(n):
            for col in range(m):
                if grid[row][col] == 1 and (rows[row] > 1 or cols[col] > 1):
                    result += 1

        return result
