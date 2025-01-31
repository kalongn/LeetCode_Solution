from typing import List


class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:

        def dfs(row, col, label):
            if (
                row < 0
                or col < 0
                or row == len(grid)
                or col == len(grid[0])
                or grid[row][col] != 1
            ):
                return 0
            grid[row][col] = label
            return (
                1
                + dfs(row + 1, col, label)
                + dfs(row, col + 1, label)
                + dfs(row - 1, col, label)
                + dfs(row, col - 1, label)
            )

        island_sizes = {}
        label = 2

        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 1:
                    island_sizes[label] = dfs(row, col, label)
                    label += 1

        if not island_sizes:
            return 1

        if len(island_sizes) == 1:
            label -= 1
            return (
                island_sizes[label]
                if island_sizes[label] == len(grid) * len(grid[0])
                else island_sizes[label] + 1
            )

        result = 1
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 0:
                    new_size = 1
                    neighbors = set()

                    if row + 1 < len(grid) and grid[row + 1][col] > 1:
                        neighbors.add(grid[row + 1][col])

                    if row - 1 >= 0 and grid[row - 1][col] > 1:
                        neighbors.add(grid[row - 1][col])

                    if col + 1 < len(grid[0]) and grid[row][col + 1] > 1:
                        neighbors.add(grid[row][col + 1])

                    if col - 1 >= 0 and grid[row][col - 1] > 1:
                        neighbors.add(grid[row][col - 1])

                    for neighbor_label in neighbors:
                        new_size += island_sizes[neighbor_label]

                    result = max(result, new_size)

        return result
