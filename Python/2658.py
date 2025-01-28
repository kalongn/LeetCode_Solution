from typing import List


class Solution:
    def findMaxFish(self, grid: List[List[int]]) -> int:

        def dfs(row, col):
            if (
                row < 0
                or col < 0
                or row == len(grid)
                or col == len(grid[0])
                or grid[row][col] == 0
            ):
                return 0

            temp = grid[row][col]
            grid[row][col] = 0

            return (
                temp
                + dfs(row - 1, col)
                + dfs(row, col - 1)
                + dfs(row + 1, col)
                + dfs(row, col + 1)
            )

        result = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] != 0:
                    result = max(result, dfs(i, j))

        return result
