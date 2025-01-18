import collections
from typing import List


class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        def is_valid(row, col, rows, cols):
            return 0 <= row < rows and 0 <= col < cols

        n, m = len(grid), len(grid[0])

        min_cost = [[float("inf")] * m for _ in range(n)]
        min_cost[0][0] = 0

        deque = collections.deque([(0, 0)])

        while deque:
            row, col = deque.popleft()

            for i, (x, y) in enumerate(dirs):
                new_row, new_col = row + x, col + y
                cost = 0 if grid[row][col] == i + 1 else 1

                if (
                    is_valid(new_row, new_col, n, m)
                    and min_cost[row][col] + cost < min_cost[new_row][new_col]
                ):
                    min_cost[new_row][new_col] = min_cost[row][col] + cost

                    if cost == 1:
                        deque.append((new_row, new_col))
                    else:
                        deque.appendleft((new_row, new_col))

        return min_cost[n - 1][m - 1]
