from typing import List


class Solution:
    def countUnguarded(
        self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]
    ) -> int:
        grid = [[0] * n for _ in range(m)]

        for guard_x, guard_y in guards:
            grid[guard_x][guard_y] = 1

        for wall_x, wall_y in walls:
            grid[wall_x][wall_y] = 2

        def dfs(x, y):
            for pos_x in range(x + 1, m):
                if grid[pos_x][y] in (1, 2):
                    break
                grid[pos_x][y] = 3
            for neg_x in reversed(range(0, x)):
                if grid[neg_x][y] in (1, 2):
                    break
                grid[neg_x][y] = 3
            for pos_y in range(y + 1, n):
                if grid[x][pos_y] in (1, 2):
                    break
                grid[x][pos_y] = 3
            for neg_y in reversed(range(0, y)):
                if grid[x][neg_y] in (1, 2):
                    break
                grid[x][neg_y] = 3

        for guard_x, guard_y in guards:
            dfs(guard_x, guard_y)

        result = 0
        for r in grid:
            for c in r:
                if c == 0:
                    result += 1
        return result
